package com.api.v1.customer.services;

import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.utils.CustomerResponseMapperUtil;
import com.api.v1.person.domain.PersonRepository;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import com.api.v1.person.exceptions.DuplicatedEmailException;
import com.api.v1.person.exceptions.DuplicatedSsnException;
import com.api.v1.person.services.PersonRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    @Autowired
    private PersonRegistrationService personRegistrationService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Mono<CustomerResponseDto> register(@Valid PersonRegistrationRequestDto requestDto) {
        return personRepository
                .findAll()
                .filter(person -> person.getSsn().equals(requestDto.ssn()))
                .hasElements()
                .flatMap(ssnExists -> {
                    if (ssnExists) return Mono.error(DuplicatedSsnException::new);
                    return personRepository
                            .findAll()
                            .filter(person -> person.getEmail().equals(requestDto.email()))
                            .hasElements()
                            .flatMap(emailExists -> {
                                if (emailExists) return Mono.error(DuplicatedEmailException::new);
                                return Mono.defer(() -> personRegistrationService.register(requestDto))
                                        .flatMap(person -> customerRepository.save(Customer.of(person)))
                                        .flatMap(customer -> Mono.just(CustomerResponseMapperUtil.map(customer)));
                            });
                });
    }

}

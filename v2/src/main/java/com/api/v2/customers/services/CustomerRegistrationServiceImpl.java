package com.api.v2.customers.services;

import com.api.v2.customers.domain.Customer;
import com.api.v2.customers.domain.CustomerRepository;
import com.api.v2.customers.dtos.CustomerResponseDto;
import com.api.v2.customers.utils.CustomerResponseMapperUtil;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import com.api.v2.persons.services.PersonRegistrationService;
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

    @Override
    public Mono<CustomerResponseDto> register(@Valid PersonRegistrationRequestDto requestDto) {
        return personRegistrationService
                .register(requestDto)
                .flatMap(person -> customerRepository
                        .save(Customer.of(person))
                        .flatMap(customer -> Mono.just(CustomerResponseMapperUtil.mapToDto(customer)))
                );
    }

}

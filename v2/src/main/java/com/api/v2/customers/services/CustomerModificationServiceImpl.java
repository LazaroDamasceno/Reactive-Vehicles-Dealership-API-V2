package com.api.v2.customers.services;

import com.api.v2.customers.domain.CustomerAuditTrail;
import com.api.v2.customers.domain.CustomerAuditTrailRepository;
import com.api.v2.customers.domain.CustomerRepository;
import com.api.v2.customers.dtos.CustomerResponseDto;
import com.api.v2.customers.utils.CustomerFinderUtil;
import com.api.v2.customers.utils.CustomerResponseMapperUtil;
import com.api.v2.persons.annotations.SSN;
import com.api.v2.persons.dtos.PersonModificationRequestDto;
import com.api.v2.persons.services.PersonModificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CustomerModificationServiceImpl implements CustomerModificationService {

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private PersonModificationService personModificationService;

    @Autowired
    private CustomerAuditTrailRepository auditTrailRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerResponseDto> modify(@SSN String ssn, @Valid PersonModificationRequestDto requestDto) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(existingCustomer -> auditTrailRepository.save(CustomerAuditTrail.of(existingCustomer))
                        .then(Mono.defer(() -> personModificationService.modify(existingCustomer.getPerson(), requestDto)))
                        .flatMap(person -> {
                            existingCustomer.setPerson(person);
                            return customerRepository.save(existingCustomer);
                        })
                        .flatMap(modifiedCustomer -> Mono.just(CustomerResponseMapperUtil.mapToDto(modifiedCustomer)))
                );
    }

}

package com.api.v1.customers.services;

import com.api.v1.customers.domain.CustomerAuditTrail;
import com.api.v1.customers.domain.CustomerAuditTrailRepository;
import com.api.v1.customers.domain.CustomerRepository;
import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.customers.utils.CustomerFinderUtil;
import com.api.v1.customers.utils.CustomerResponseMapperUtil;
import com.api.v1.persons.annotations.SSN;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import com.api.v1.persons.services.PersonModificationService;
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
                        .then(Mono.defer(() -> personModificationService.modify(existingCustomer.getPersonEntity(), requestDto)))
                        .flatMap(person -> {
                            existingCustomer.setPersonEntity(person);
                            return customerRepository.save(existingCustomer);
                        })
                        .flatMap(modifiedCustomer -> Mono.just(CustomerResponseMapperUtil.map(modifiedCustomer)))
                );
    }

}

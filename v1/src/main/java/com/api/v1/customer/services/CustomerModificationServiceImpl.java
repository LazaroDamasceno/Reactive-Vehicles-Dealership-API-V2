package com.api.v1.customer.services;

import com.api.v1.customer.domain.CustomerAuditTrail;
import com.api.v1.customer.domain.CustomerAuditTrailRepository;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.utils.CustomerFinderUtil;
import com.api.v1.customer.utils.CustomerResponseMapperUtil;
import com.api.v1.person.annotations.SSN;
import com.api.v1.person.dtos.PersonModificationRequestDto;
import com.api.v1.person.services.PersonModificationService;
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
                            existingCustomer.modify(person);
                            return customerRepository.save(existingCustomer);
                        })
                        .flatMap(modifiedCustomer -> Mono.just(CustomerResponseMapperUtil.map(modifiedCustomer)))
                );
    }

}

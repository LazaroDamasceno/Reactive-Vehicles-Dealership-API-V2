package com.api.v2.customers.services;

import com.api.v2.customers.domain.CustomerRepository;
import com.api.v2.customers.exceptions.UnchangeableCustomerException;
import com.api.v2.customers.utils.CustomerFinderUtil;
import com.api.v2.persons.PersonDeletionService;
import com.api.v2.persons.annotations.SSN;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class CustomerDeletionServiceImpl implements CustomerDeletionService {

    private final CustomerFinderUtil customerFinderUtil;
    private final PersonDeletionService personDeletionService;
    private final CustomerRepository customerRepository;

    @Override
    public Mono<Void> delete(@SSN String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(customer -> personDeletionService.bookDeletion(customer.getPerson())
                        .then(Mono.defer(() -> {
                            if (customer.getBookedDeletionDate() != null) {
                                return Mono.error(new UnchangeableCustomerException(customer.getBookedDeletionDate()));
                            }
                           customer.bookDeletion();
                           return customerRepository.save(customer);
                })))
                .then();
    }

}

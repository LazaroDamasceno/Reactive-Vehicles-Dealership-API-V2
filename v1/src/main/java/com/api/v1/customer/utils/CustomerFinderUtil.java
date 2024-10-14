package com.api.v1.customer.utils;

import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;
import com.api.v1.person.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomerFinderUtil {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Mono<Customer> find(String ssn) {
        return personRepository
                .findBySsn(ssn)
                .switchIfEmpty(Mono.error(CustomerNotFoundException::new))
                .flatMap(person -> customerRepository.findByPerson(person));
    }

}

package com.api.v1.customers.utils;

import com.api.v1.customers.domain.Customer;
import com.api.v1.customers.domain.CustomerRepository;
import com.api.v1.customers.exceptions.CustomerNotFoundException;
import com.api.v1.persons.domain.PersonRepository;
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
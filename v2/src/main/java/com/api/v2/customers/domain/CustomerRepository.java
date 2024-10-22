package com.api.v2.customers.domain;

import com.api.v2.persons.domain.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, UUID> {

    @Query("{ 'person': ?0 }")
    Mono<Customer> findByPerson(Person person);
}

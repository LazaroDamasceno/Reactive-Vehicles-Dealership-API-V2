package com.api.v1.customer;

import com.api.v1.person.domain.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, UUID> {

    @Query("{ 'person': ?0 }")
    Mono<Customer> findByPerson(Person person);
}

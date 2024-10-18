package com.api.v1.customers.domain;

import com.api.v1.persons.domain.PersonEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerRepository extends ReactiveMongoRepository<CustomerEntity, UUID> {

    @Query("{ 'person': ?0 }")
    Mono<CustomerEntity> findByPerson(PersonEntity personEntity);
}

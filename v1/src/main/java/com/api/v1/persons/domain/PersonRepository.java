package com.api.v1.persons.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PersonRepository extends ReactiveMongoRepository<PersonEntity, UUID> {

    @Query("{ 'ssn': ?0 }")
    Mono<PersonEntity> findBySsn(String ssn);

    @Query("{ 'email': ?0 }")
    Mono<PersonEntity> findByEmail(String email);

}

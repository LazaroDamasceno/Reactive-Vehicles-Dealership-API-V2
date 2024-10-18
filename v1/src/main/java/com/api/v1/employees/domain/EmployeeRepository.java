package com.api.v1.employees.domain;

import com.api.v1.persons.domain.PersonEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveMongoRepository<EmployeeEntity, UUID> {

    @Query("{ 'person': ?0 }")
    Mono<EmployeeEntity> findByPerson(PersonEntity personEntity);

}

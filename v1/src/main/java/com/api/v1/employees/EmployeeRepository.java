package com.api.v1.employees;

import com.api.v1.persons.domain.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, UUID> {

    @Query("{ 'person': ?0 }")
    Mono<Employee> findByPerson(Person person);

}

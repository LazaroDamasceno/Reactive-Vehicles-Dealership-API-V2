package com.api.v1.employees.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, UUID> {

    @Query("{ 'employeeId': ?0 }")
    Mono<Employee> findByEmployeeId(String employeeId);

}

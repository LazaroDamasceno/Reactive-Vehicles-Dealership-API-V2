package com.api.v1.employees;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, UUID> {
}

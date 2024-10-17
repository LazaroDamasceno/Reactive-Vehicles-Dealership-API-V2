package com.api.v1.employee;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, UUID> {
}

package com.api.v1.employees.services;

import com.api.v1.employees.domain.Employee;
import com.api.v1.persons.domain.Person;
import reactor.core.publisher.Mono;

public interface EmployeeRegistrationService {

    Mono<Employee> register(Person person);

}

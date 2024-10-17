package com.api.v1.employees;

import com.api.v1.persons.domain.Person;
import reactor.core.publisher.Mono;

public interface EmployeeRegistrationService {

    Mono<Employee> register(Person person);

}

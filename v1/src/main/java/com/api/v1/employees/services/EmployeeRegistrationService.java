package com.api.v1.employees.services;

import com.api.v1.employees.domain.EmployeeEntity;
import com.api.v1.persons.domain.PersonEntity;
import reactor.core.publisher.Mono;

public interface EmployeeRegistrationService {

    Mono<EmployeeEntity> register(PersonEntity personEntity);

}

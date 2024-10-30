package com.api.v2.employees.services;

import reactor.core.publisher.Mono;

public interface EmployeeTerminationService {

    Mono<Void> terminate(String employeeId);

}

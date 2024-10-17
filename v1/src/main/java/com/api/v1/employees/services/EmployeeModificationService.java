package com.api.v1.employees.services;

import com.api.v1.employees.domain.Employee;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface EmployeeModificationService {

    Mono<Employee> modify(Employee employee, PersonModificationRequestDto requestDto);

}

package com.api.v1.employees.utils;

import com.api.v1.employees.annotations.EmployeeId;
import com.api.v1.employees.domain.Employee;
import com.api.v1.employees.domain.EmployeeRepository;
import com.api.v1.employees.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class EmployeeFinderUtil {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Mono<Employee> find(@EmployeeId String employeeId) {
        return employeeRepository
                .findByEmployeeId(employeeId)
                .switchIfEmpty(Mono.error(EmployeeNotFoundException::new));
    }

}

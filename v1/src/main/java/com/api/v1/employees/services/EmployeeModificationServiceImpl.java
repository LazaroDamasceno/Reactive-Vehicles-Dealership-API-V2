package com.api.v1.employees.services;

import com.api.v1.employees.domain.Employee;
import com.api.v1.employees.domain.EmployeeRepository;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import com.api.v1.persons.services.PersonModificationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class EmployeeModificationServiceImpl implements EmployeeModificationService {

    @Autowired
    private PersonModificationService personModificationService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> modify(@NotNull Employee employee, @Valid PersonModificationRequestDto requestDto) {
        return personModificationService
                .modify(employee.getPerson(), requestDto)
                .flatMap(person -> {
                    employee.setPerson(person);
                    return employeeRepository.save(employee);
                });
    }

}

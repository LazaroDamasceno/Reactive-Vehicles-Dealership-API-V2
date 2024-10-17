package com.api.v1.employees;

import com.api.v1.persons.domain.Person;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Mono<Employee> register(@NotNull Person person) {
        return repository.save(Employee.of(person));
    }

}

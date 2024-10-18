package com.api.v1.employees.services.abstracts;

import com.api.v1.employees.domain.EmployeeRepository;
import com.api.v1.employees.dtos.EmployeeResponseDto;
import com.api.v1.persons.dtos.PersonRegistrationRequestDto;
import com.api.v1.persons.services.PersonRegistrationService;
import reactor.core.publisher.Mono;

public abstract class EmployeeRegistrationService {

    protected final PersonRegistrationService personRegistrationService;
    protected final EmployeeRepository employeeRepository;

    public EmployeeRegistrationService(
            PersonRegistrationService personRegistrationService,
            EmployeeRepository employeeRepository) {
        this.personRegistrationService = personRegistrationService;
        this.employeeRepository = employeeRepository;
    }

    public abstract Mono<EmployeeResponseDto> register(PersonRegistrationRequestDto requestDto);

}

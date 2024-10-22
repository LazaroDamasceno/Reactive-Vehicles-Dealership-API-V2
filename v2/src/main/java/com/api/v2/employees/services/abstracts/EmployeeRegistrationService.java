package com.api.v2.employees.services.abstracts;

import com.api.v2.employees.domain.EmployeeRepository;
import com.api.v2.employees.dtos.EmployeeResponseDto;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import com.api.v2.persons.services.PersonRegistrationService;
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

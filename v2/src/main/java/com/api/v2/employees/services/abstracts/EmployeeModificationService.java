package com.api.v2.employees.services.abstracts;

import com.api.v2.employees.domain.EmployeeRepository;
import com.api.v2.employees.dtos.EmployeeResponseDto;
import com.api.v2.employees.utils.EmployeeFinderUtil;
import com.api.v2.persons.dtos.PersonModificationRequestDto;
import com.api.v2.persons.services.PersonModificationService;
import reactor.core.publisher.Mono;

public abstract class EmployeeModificationService {

    protected final EmployeeFinderUtil employeeFinderUtil;
    protected final PersonModificationService personModificationService;
    protected final EmployeeRepository employeeRepository;

    public EmployeeModificationService(
            EmployeeFinderUtil employeeFinderUtil,
            PersonModificationService personModificationService,
            EmployeeRepository employeeRepository
    ) {
        this.employeeFinderUtil = employeeFinderUtil;
        this.personModificationService = personModificationService;
        this.employeeRepository = employeeRepository;
    }

    public abstract Mono<EmployeeResponseDto> modify(String employeeId, PersonModificationRequestDto requestDto);

}

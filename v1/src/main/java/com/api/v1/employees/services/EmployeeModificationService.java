package com.api.v1.employees.services;

import com.api.v1.employees.domain.EmployeeEntity;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface EmployeeModificationService {

    Mono<EmployeeEntity> modify(EmployeeEntity employeeEntity, PersonModificationRequestDto requestDto);

}

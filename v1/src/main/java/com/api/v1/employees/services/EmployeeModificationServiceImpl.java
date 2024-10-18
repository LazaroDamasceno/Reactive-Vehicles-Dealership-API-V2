package com.api.v1.employees.services;

import com.api.v1.employees.annotations.EmployeeId;
import com.api.v1.employees.domain.EmployeeRepository;
import com.api.v1.employees.dtos.EmployeeResponseDto;
import com.api.v1.employees.services.abstracts.EmployeeModificationService;
import com.api.v1.employees.utils.EmployeeFinderUtil;
import com.api.v1.employees.utils.EmployeeResponseMapperUtil;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import com.api.v1.persons.services.PersonModificationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EmployeeModificationServiceImpl extends EmployeeModificationService {

    public EmployeeModificationServiceImpl(
            EmployeeFinderUtil employeeFinderUtil,
            PersonModificationService personModificationService,
            EmployeeRepository employeeRepository
    ) {
        super(employeeFinderUtil, personModificationService, employeeRepository);
    }

    @Override
    public Mono<EmployeeResponseDto> modify(
            @EmployeeId String employeeId,
            @Valid PersonModificationRequestDto requestDto
    ) {
        return employeeFinderUtil
                .find(employeeId)
                .flatMap(employee -> personModificationService.modify(employee.getPerson(), requestDto)
                    .flatMap(person -> {
                        employee.setPerson(person);
                        return employeeRepository
                                .save(employee)
                                .flatMap(EmployeeResponseMapperUtil::mapToMono);
                    }));
    }

}

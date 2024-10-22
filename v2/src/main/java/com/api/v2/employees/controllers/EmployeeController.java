package com.api.v2.employees.controllers;

import com.api.v2.employees.annotations.EmployeeId;
import com.api.v2.employees.dtos.EmployeeResponseDto;
import com.api.v2.employees.services.EmployeeModificationServiceImpl;
import com.api.v2.employees.services.EmployeeRetrievalService;
import com.api.v2.employees.services.salesperson.SalespersonRegistrationServiceImpl;
import com.api.v2.persons.dtos.PersonModificationRequestDto;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v2/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeModificationServiceImpl employeeModificationService;
    private final SalespersonRegistrationServiceImpl salespersonRegistrationService;
    private final EmployeeRetrievalService employeeRetrievalService;

    @PostMapping("salesperson")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeResponseDto> register(@Valid @RequestBody PersonRegistrationRequestDto requestDto) {
        return salespersonRegistrationService.register(requestDto);
    }

    @PutMapping("{employeeId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<EmployeeResponseDto> modify(
            @EmployeeId @PathVariable String employeeId,
            @Valid @RequestBody PersonModificationRequestDto requestDto
    ) {
        return employeeModificationService.modify(employeeId, requestDto);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<EmployeeResponseDto> findAll() {
        return employeeRetrievalService.findAll();
    }

}

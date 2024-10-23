package com.api.v2.customers.controller;

import com.api.v2.customers.dtos.CustomerResponseDto;
import com.api.v2.customers.services.CustomerDeletionService;
import com.api.v2.customers.services.CustomerModificationService;
import com.api.v2.customers.services.CustomerRegistrationService;
import com.api.v2.customers.services.CustomerRetrievalService;
import com.api.v2.persons.annotations.SSN;
import com.api.v2.persons.dtos.PersonModificationRequestDto;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v2/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRegistrationService registrationService;
    private final CustomerModificationService modificationService;
    private final CustomerRetrievalService customerRetrievalService;
    private final CustomerDeletionService customerDeletionService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerResponseDto> register(@Valid @RequestBody PersonRegistrationRequestDto requestDto) {
        return registrationService.register(requestDto);
    }

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerResponseDto> modify(
            @SSN @PathVariable String ssn,
            @RequestBody @Valid PersonModificationRequestDto requestDto
    ) {
        return modificationService.modify(ssn, requestDto);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CustomerResponseDto> findAll() {
        return customerRetrievalService.findAll();
    }

    @PatchMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@SSN @PathVariable String ssn) {
        return customerDeletionService.delete(ssn);
    }
}

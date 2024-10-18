package com.api.v1.customers.controller;

import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.customers.services.CustomerModificationService;
import com.api.v1.customers.services.CustomerRegistrationService;
import com.api.v1.customers.services.CustomerRetrievalService;
import com.api.v1.persons.annotations.SSN;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import com.api.v1.persons.dtos.PersonRegistrationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRegistrationService registrationService;

    @Autowired
    private CustomerModificationService modificationService;

    @Autowired
    private CustomerRetrievalService customerRetrievalService;

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

}

package com.api.v1.customer.controller;

import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.services.CustomerModificationService;
import com.api.v1.customer.services.CustomerRegistrationService;
import com.api.v1.person.annotations.SSN;
import com.api.v1.person.dtos.PersonModificationRequestDto;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRegistrationService registrationService;

    @Autowired
    private CustomerModificationService modificationService;

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

}

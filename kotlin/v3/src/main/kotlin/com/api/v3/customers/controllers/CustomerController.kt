package com.api.v3.customers.controllers

import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.services.CustomerModificationService
import com.api.v3.customers.services.CustomerRegistrationService
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v3/customers")
class CustomerController(
    private val registrationService: CustomerRegistrationService,
    private val customerModificationService: CustomerModificationService
) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(
        @RequestBody requestDto: @Valid PersonRegistrationRequestDto
    ): CustomerResponseDto {
        return registrationService.register(requestDto)
    }

    @PutMapping("{ssn}")
    suspend fun modify(
        @PathVariable ssn: String,
        @RequestBody requestDto: @Valid PersonModificationRequestDto
    ): CustomerResponseDto {
        return customerModificationService.modify(ssn, requestDto)
    }

}
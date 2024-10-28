package com.api.v3.customers.controllers

import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.services.CustomerModificationService
import com.api.v3.customers.services.CustomerRegistrationService
import com.api.v3.customers.services.CustomerRetrievalService
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v3/customers")
class CustomerController(
    private val registrationService: CustomerRegistrationService,
    private val modificationService: CustomerModificationService,
    private val retrievalService: CustomerRetrievalService
) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(
        @RequestBody requestDto: @Valid PersonRegistrationRequestDto
    ): CustomerResponseDto {
        return registrationService.register(requestDto)
    }

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun modify(
        @PathVariable ssn: String,
        @RequestBody requestDto: @Valid PersonModificationRequestDto
    ): CustomerResponseDto {
        return modificationService.modify(ssn, requestDto)
    }

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findBySsn(@PathVariable ssn: String): CustomerResponseDto {
        return retrievalService.findBySsn(ssn)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<CustomerResponseDto> {
        return retrievalService.findAll()
    }

}
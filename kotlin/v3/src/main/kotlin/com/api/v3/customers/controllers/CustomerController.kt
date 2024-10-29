package com.api.v3.customers.controllers

import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.services.CustomerModificationService
import com.api.v3.customers.services.CustomerRegistrationService
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v3/customers")
class CustomerController {

    @Autowired
    private lateinit var registrationService: CustomerRegistrationService

    @Autowired
    private lateinit var modificationService: CustomerModificationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody requestDto: @Valid PersonRegistrationRequestDto) {
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

}
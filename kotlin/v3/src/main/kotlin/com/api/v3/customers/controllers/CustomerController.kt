package com.api.v3.customers.controllers

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
    private lateinit var customerModificationService: CustomerModificationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody requestDto: @Valid PersonRegistrationRequestDto) {
        return registrationService.register(requestDto)
    }

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun modify(@PathVariable ssn: String, @RequestBody @Valid requestDto: PersonModificationRequestDto) {
        return customerModificationService.modify(ssn, requestDto)
    }

}
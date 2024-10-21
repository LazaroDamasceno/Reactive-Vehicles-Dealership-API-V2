package com.api.v2.customers.controllers

import com.api.v2.customers.services.CustomerRegistrationService
import com.api.v2.persons.dtos.PersonRegistrationDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/customers")
class CustomerController {

    @Autowired
    lateinit var customerRegistrationService: CustomerRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody personRegistrationDto: @Valid PersonRegistrationDto) {
        return customerRegistrationService.register(personRegistrationDto)
    }

}
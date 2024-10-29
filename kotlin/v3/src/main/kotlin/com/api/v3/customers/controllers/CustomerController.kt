package com.api.v3.customers.controllers

import com.api.v3.customers.services.CustomerRegistrationService
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v3/customers")
class CustomerController {

    @Autowired
    private lateinit var registrationService: CustomerRegistrationService

    @PostMapping
    suspend fun register(@RequestBody requestDto: @Valid PersonRegistrationRequestDto) {
        return registrationService.register(requestDto)
    }

}
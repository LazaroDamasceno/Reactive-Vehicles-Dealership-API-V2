package com.api.v3.customers.controllers

import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.services.CustomerRegistrationService
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v3/customers")
class CustomerController {

    @Autowired
    private lateinit var registrationService: CustomerRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody requestDto: @Valid PersonRegistrationRequestDto): CustomerResponseDto {
        return registrationService.register(requestDto)
    }


}
package com.api.v2.customers.controllers

import com.api.v2.customers.services.CustomerBookDeletion
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
    lateinit var customerBookDeletion: CustomerBookDeletion

    @Autowired
    lateinit var customerRegistrationService: CustomerRegistrationService

    @PatchMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun bookDeletion(@PathVariable ssn: String) {
        return customerBookDeletion.bookDeletion(ssn)
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody personRegistrationDto: @Valid PersonRegistrationDto) {
        return customerRegistrationService.register(personRegistrationDto)
    }

}
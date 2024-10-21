package com.api.v2.customers.services

import com.api.v2.customers.dtos.CustomerResponseDto
import com.api.v2.persons.dtos.PersonRegistrationDto

interface CustomerRegistrationService {

    suspend fun register(personRegistrationDto: PersonRegistrationDto): CustomerResponseDto

}
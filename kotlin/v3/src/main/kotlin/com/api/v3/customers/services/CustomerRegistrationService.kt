package com.api.v3.customers.services

import com.api.v3.persons.dtos.PersonRegistrationRequestDto

interface CustomerRegistrationService {

    suspend fun register(requestDto: PersonRegistrationRequestDto)

}
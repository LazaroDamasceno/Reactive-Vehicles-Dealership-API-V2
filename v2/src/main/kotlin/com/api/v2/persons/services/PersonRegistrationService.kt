package com.api.v2.persons.services

import com.api.v2.persons.dtos.PersonRegistrationDto

interface PersonRegistrationService {

    suspend fun register(requestDto: PersonRegistrationDto)

}
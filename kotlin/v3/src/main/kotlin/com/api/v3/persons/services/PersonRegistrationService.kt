package com.api.v3.persons.services

import com.api.v3.persons.domain.Person
import com.api.v3.persons.dtos.PersonRegistrationRequestDto

interface PersonRegistrationService {

    suspend fun register(requestDto: PersonRegistrationRequestDto): Person

}
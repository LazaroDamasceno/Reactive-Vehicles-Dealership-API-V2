package com.api.v2.persons

interface PersonRegistrationService {

    suspend fun register(requestDto: PersonRegistrationDto)

}
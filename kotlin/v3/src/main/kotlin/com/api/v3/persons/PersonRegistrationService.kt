package com.api.v3.persons

interface PersonRegistrationService {

    suspend fun register(requestDto: PersonRegistrationRequestDto): Person

}
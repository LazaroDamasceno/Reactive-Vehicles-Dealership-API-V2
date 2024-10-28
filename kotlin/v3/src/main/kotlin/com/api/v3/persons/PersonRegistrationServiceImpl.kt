package com.api.v3.persons

import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
internal class PersonRegistrationServiceImpl(
    private val personRepository: PersonRepository
): PersonRegistrationService {

    override suspend fun register(requestDto: @Valid PersonRegistrationRequestDto) {
        TODO("Not yet implemented")
    }

}
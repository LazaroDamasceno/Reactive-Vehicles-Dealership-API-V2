package com.api.v2.persons

import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class PersonRegistrationServiceImpl: PersonRegistrationService {

    @Autowired
    lateinit var personRepository: PersonRepository

    override suspend fun register(requestDto: @Valid PersonRegistrationDto) {
        return withContext(Dispatchers.IO) {
            isSsnDuplicated(requestDto.ssn)
            val person = Person.of(requestDto)
            personRepository.save(person)
        }
    }

    private suspend fun isSsnDuplicated(ssn: String) {
        if (personRepository.findBySsn(ssn) != null) {
            throw DuplicatedSsnException()
        }
    }

}
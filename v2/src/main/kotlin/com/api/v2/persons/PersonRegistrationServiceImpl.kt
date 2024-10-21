package com.api.v2.persons

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
private class PersonRegistrationServiceImpl: PersonRegistrationService {

    private val personRepository: PersonRepository

    constructor(personRepository: PersonRepository) {
        this.personRepository = personRepository
    }

    override suspend fun register(requestDto: PersonRegistrationDto) {
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
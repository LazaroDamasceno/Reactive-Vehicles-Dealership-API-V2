package com.api.v3.persons.services

import com.api.v3.persons.domain.Person
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import com.api.v3.persons.domain.PersonRepository
import com.api.v3.persons.exceptions.DuplicatedEmailException
import com.api.v3.persons.exceptions.DuplicatedSsnException
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
internal class PersonRegistrationServiceImpl(
    private val personRepository: PersonRepository
): PersonRegistrationService {

    override suspend fun register(requestDto: @Valid PersonRegistrationRequestDto): Person {
        return withContext(Dispatchers.IO) {
            isGivenSsnDuplicated(requestDto.ssn)
            isGivenEmailDuplicated(requestDto.email)
            personRepository.save(Person.of(requestDto))
        }
    }

    private suspend fun isGivenSsnDuplicated(ssn: String) {
        if (personRepository.findBySsn(ssn) != null) {
            throw DuplicatedSsnException()
        }
    }

    private suspend fun isGivenEmailDuplicated(email: String) {
        if (personRepository.findByEmail(email) != null) {
            throw DuplicatedEmailException()
        }
    }

}
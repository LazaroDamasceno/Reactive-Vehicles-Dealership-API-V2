package com.api.v3.persons.services

import com.api.v3.persons.domain.Person
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import com.api.v3.persons.domain.PersonRepository
import com.api.v3.persons.exceptions.DuplicatedEmailException
import com.api.v3.persons.exceptions.DuplicatedSsnException
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonRegistrationServiceImpl: PersonRegistrationService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    override suspend fun register(requestDto: @Valid PersonRegistrationRequestDto): Person {
        return withContext(Dispatchers.IO) {
            isGivenSsnDuplicated(requestDto.ssn)
            isGivenEmailDuplicated(requestDto.email)
            personRepository.save(Person.of(requestDto))
        }
    }

    private suspend fun isGivenSsnDuplicated(ssn: String) {
        val existingPerson = personRepository
            .findAll()
            .filter { e -> e.ssn == ssn }
            .singleOrNull()
        if (existingPerson != null) {
            throw DuplicatedSsnException()
        }
    }

    private suspend fun isGivenEmailDuplicated(email: String) {
        val existingPerson = personRepository
            .findAll()
            .filter { e -> e.email == email }
            .singleOrNull()
        if (existingPerson != null) {
            throw DuplicatedEmailException()
        }
    }

}
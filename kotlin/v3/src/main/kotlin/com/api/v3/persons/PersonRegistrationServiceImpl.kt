package com.api.v3.persons

import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
internal class PersonRegistrationServiceImpl(
    private val personRepository: PersonRepository
): PersonRegistrationService {

    override suspend fun register(requestDto: @Valid PersonRegistrationRequestDto): Person {

        fun isGivenSsnDuplicated() {
            if (personRepository.findBySsn(requestDto.ssn) == null) {
                throw DuplicatedSsnException()
            }
        }

        fun isGivenEmailDuplicated() {
            if (personRepository.findByEmail(requestDto.email) == null) {
                throw DuplicatedEmailException()
            }
        }

        suspend fun response(): Person {
            return personRepository.save(Person.of(requestDto))
        }

        return withContext(Dispatchers.IO) {
            isGivenSsnDuplicated()
            isGivenEmailDuplicated()
            response()
        }
    }

}
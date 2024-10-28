package com.api.v3.persons.services

import com.api.v3.persons.domain.Person
import com.api.v3.persons.domain.PersonRepository
import com.api.v3.persons.dtos.PersonModificationRequestDto
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Service

@Service
internal class PersonModificationServiceImpl(
    private val personRepository: PersonRepository
): PersonModificationService {

    override suspend fun modify(
        @NotNull person: Person,
        requestDto: @Valid PersonModificationRequestDto
    ): Person {
        return withContext(Dispatchers.IO) {
            person.modify(requestDto)
            personRepository.save(person)
        }
    }

}
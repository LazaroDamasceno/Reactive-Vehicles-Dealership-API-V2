package com.api.v3.persons.services

import com.api.v3.persons.domain.Person
import com.api.v3.persons.domain.PersonAuditTrail
import com.api.v3.persons.domain.PersonAuditTrailRepository
import com.api.v3.persons.domain.PersonRepository
import com.api.v3.persons.dtos.PersonModificationRequestDto
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonModificationServiceImpl: PersonModificationService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var personAuditTrailRepository: PersonAuditTrailRepository

    override suspend fun modify(
        @NotNull person: Person,
        requestDto: @Valid PersonModificationRequestDto
    ): Person {
        return withContext(Dispatchers.IO) {
            val auditTrail = PersonAuditTrail.of(person)
            val savedAuditTrail = personAuditTrailRepository.save(auditTrail)
            person.modify(requestDto)
            personRepository.save(person)
        }
    }

}
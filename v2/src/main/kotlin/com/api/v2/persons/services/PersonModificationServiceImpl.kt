package com.api.v2.persons.services

import com.api.v2.persons.domain.Person
import com.api.v2.persons.domain.PersonAuditTrail
import com.api.v2.persons.domain.PersonAuditTrailRepository
import com.api.v2.persons.domain.PersonRepository
import com.api.v2.persons.dtos.PersonModificationDto
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class PersonModificationServiceImpl: PersonModificationService {

    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var personAuditTrailRepository: PersonAuditTrailRepository

    override suspend fun modify(
        person: @NotNull Person,
        requestModificationDto: @Valid PersonModificationDto
    ): Person {
        return withContext(Dispatchers.IO) {
            val personAuditTrail = PersonAuditTrail.of(person)
            val savedAuditTrail = personAuditTrailRepository.save(personAuditTrail)
            person.modify(requestModificationDto)
            personRepository.save(person)
        }
    }

}

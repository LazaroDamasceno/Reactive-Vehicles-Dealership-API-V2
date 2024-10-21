package com.api.v2.persons

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

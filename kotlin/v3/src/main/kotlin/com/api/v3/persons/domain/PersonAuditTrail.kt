package com.api.v3.persons.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Document
data class PersonAuditTrail(
    @Id
    val id: UUID,
    val person: Person,
    val createdAt: LocalDateTime,
    val createdAtZone: ZoneId
) {

    companion object {
        fun of(person: Person): PersonAuditTrail {
            return PersonAuditTrail(
                UUID.randomUUID(),
                person,
                LocalDateTime.now(),
                ZoneId.systemDefault()
            )
        }
    }

}
package com.api.v2.persons.domain

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
data class PersonAuditTrail(
    val id: UUID,
    val person: Person,
    val createdAt: LocalDateTime,
    val createdAtZone: ZoneId
) {

    private constructor(person: Person): this(
        UUID.randomUUID(),
        person,
        LocalDateTime.now(),
        ZoneId.systemDefault()
    )

    companion object {
        fun of(person: Person): PersonAuditTrail {
            return PersonAuditTrail(person)
        }
    }

}
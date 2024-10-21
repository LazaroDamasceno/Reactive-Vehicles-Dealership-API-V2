package com.api.v2.customers.domain

import com.api.v2.persons.domain.Person
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
class Customer {

    val id: UUID = UUID.randomUUID()
    var isActive: Boolean = true
    var person: Person
    val createdAt: LocalDateTime = LocalDateTime.now()
    val createdAtZone: ZoneId = ZoneId.systemDefault()

    private constructor(person: Person) {
        this.person = person
    }

    companion object {
        fun of(person: Person): Customer {
            return Customer(person)
        }
    }

}
package com.api.v3.customers.domain

import com.api.v3.persons.domain.Person
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
class Customer {

    @Id
    var id: UUID = UUID.randomUUID()
    var person: Person
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()

    private constructor(person: Person) {
        this.person = person
    }

    companion object {
        fun of(person: Person): Customer {
            return Customer(person)
        }
    }

}
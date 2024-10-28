package com.api.v3.customers

import com.api.v3.persons.domain.Person
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
class Customer {

    val id: UUID = UUID.randomUUID()
    lateinit var person: Person
    val createdAt: LocalDateTime = LocalDateTime.now()
    val createdAtZone: ZoneId = ZoneId.systemDefault()

    companion object {
        fun of(person: Person): Customer {
            val customer = Customer()
            customer.person = person
            return customer
        }
    }

}
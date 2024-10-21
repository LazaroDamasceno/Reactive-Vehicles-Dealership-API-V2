package com.api.v2.customers.domain

import com.api.v2.persons.domain.Person
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
class Customer {

    val id: UUID = UUID.randomUUID()
    var person: Person
    val createdAt: LocalDateTime = LocalDateTime.now()
    val createdAtZone: ZoneId = ZoneId.systemDefault()
    var isActive: Boolean = true
    var bookedDeletionDate: LocalDateTime? = null

    private constructor(person: Person) {
        this.person = person
    }

    companion object {
        fun of(person: Person): Customer {
            return Customer(person)
        }
    }

    fun setBookedDeletionDate(person: Person) {
        this.person = person
        this.isActive = false
        this.bookedDeletionDate = LocalDateTime.now().plusYears(5)
    }

}
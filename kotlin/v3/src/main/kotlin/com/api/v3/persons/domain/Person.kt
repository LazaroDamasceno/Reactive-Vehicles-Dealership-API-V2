package com.api.v3.persons.domain

import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Document
class Person {

    @Id
    var id: UUID = UUID.randomUUID()
    lateinit var firstName: String
    var middleName: String? = null
    lateinit var lastName: String
    lateinit var ssn: String
    lateinit var birthDate: LocalDate
    lateinit var email: String
    lateinit var address: String
    lateinit var gender: String
    lateinit var phoneNumber: String
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()
    var modifiedAt: LocalDateTime? = null
    var modifiedAtZone: ZoneId? = null

    companion object {
        fun of(requestDto: PersonRegistrationRequestDto): Person {
            val person = Person()
            person.firstName = requestDto.firstName
            person.middleName = requestDto.middleName
            person.lastName = requestDto.lastName
            person.ssn = requestDto.ssn
            person.birthDate = requestDto.birthDate
            person.email = requestDto.email
            person.address = requestDto.address
            person.gender = requestDto.gender
            person.phoneNumber = requestDto.phoneNumber
            return person
        }
    }

    fun fullName(): String {
        if (middleName.isNullOrEmpty()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }

    fun modify(requestDto: PersonModificationRequestDto) {
        firstName = requestDto.firstName
        middleName = requestDto.firstName
        lastName = requestDto.firstName
        email = requestDto.email
        birthDate = requestDto.birthDate
        address = requestDto.address
        gender = requestDto.gender
        phoneNumber = requestDto.phoneNumber
        modifiedAt = LocalDateTime.now()
        modifiedAtZone = ZoneId.systemDefault()
    }

}
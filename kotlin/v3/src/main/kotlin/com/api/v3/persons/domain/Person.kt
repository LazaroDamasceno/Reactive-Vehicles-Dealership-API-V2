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
    var firstName: String
    var middleName: String? = null
    var lastName: String
    var ssn: String
    var birthDate: LocalDate
    var email: String
    var address: String
    var gender: String
    var phoneNumber: String
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()
    var modifiedAt: LocalDateTime? = null
    var modifiedAtZone: ZoneId? = null

    private constructor(requestDto: PersonRegistrationRequestDto) {
        this.firstName = requestDto.firstName
        this.middleName = requestDto.middleName
        this.lastName = requestDto.lastName
        this.ssn = requestDto.ssn
        this.birthDate = requestDto.birthDate
        this.email = requestDto.email
        this.address = requestDto.address
        this.gender = requestDto.gender
        this.phoneNumber = requestDto.phoneNumber
    }

    companion object {
        fun of(requestDto: PersonRegistrationRequestDto): Person {
            return Person(requestDto)
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
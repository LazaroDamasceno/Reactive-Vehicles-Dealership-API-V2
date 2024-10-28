package com.api.v3.persons.domain

import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Document
class Person(
    var firstName: String,
    var middleName: String?,
    var lastName: String,
    var ssn: String,
    var birthDate: LocalDate,
    var email: String,
    var address: String,
    var gender: String,
    var phoneNumber: String
) {

    @Id
    val id: UUID = UUID.randomUUID()
    val createdAt: LocalDateTime = LocalDateTime.now()
    val createdAtZone: ZoneId = ZoneId.systemDefault()

    companion object {
        fun of(requestDto: PersonRegistrationRequestDto): Person {
            return Person(
                requestDto.firstName,
                requestDto.middleName,
                requestDto.lastName,
                requestDto.ssn,
                requestDto.birthDate,
                requestDto.email,
                requestDto.address,
                requestDto.gender,
                requestDto.phoneNumber
            )
        }
    }

    fun fullName(): String {
        if (middleName.isNullOrEmpty()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }

}
package com.api.v2.persons

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

@Document
class Person {

    val id: UUID = UUID.randomUUID()
    var firstName: String
    var middleName: String?
    var lastName: String
    val ssn: String
    var birthDate: LocalDate
    var email: String
    var address: String
    var gender: String
    var phoneNumber: String
    val createdAt: LocalDateTime = LocalDateTime.now()
    val createdAtZone: ZoneId = ZoneId.systemDefault()
    var modifiedAt: LocalDateTime? = null
    var modifiedAtZone: ZoneId? = null

    private constructor(requestDto: PersonRegistrationDto) {
        this.ssn = requestDto.ssn
        this.firstName = requestDto.firstName
        this.middleName = requestDto.middleName
        this.lastName = requestDto.lastName
        this.birthDate = requestDto.birthDate
        this.email = requestDto.email
        this.address = requestDto.address
        this.gender = requestDto.gender
        this.phoneNumber = requestDto.phoneNumber
    }

    companion object {
        fun of(requestDto: PersonRegistrationDto): Person {
            return Person(requestDto)
        }
    }

    fun modify(requestDto: PersonModificationDto) {
        this.firstName = requestDto.firstName
        this.middleName = requestDto.middleName
        this.lastName = requestDto.lastName
        this.birthDate = requestDto.birthDate
        this.email = requestDto.email
        this.address = requestDto.address
        this.gender = requestDto.gender
        this.phoneNumber = requestDto.phoneNumber
        this.modifiedAt = LocalDateTime.now()
        this.modifiedAtZone = ZoneId.systemDefault()
    }

}
package com.api.v3.persons.dtos

import java.time.LocalDate

data class PersonResponseDto(
    var fullName: String,
    var ssn: String,
    var birthDate: LocalDate,
    var email: String,
    var address: String,
    var gender: String,
    var phoneNumber: String
)

package com.api.v2.persons.dtos

import java.time.LocalDate

data class PersonResponseDto(
    val fullName: String,
    val birthDate: LocalDate,
    val ssn: String,
    val email: String,
    val address: String,
    val gender: String,
    val phoneNumber: String
)

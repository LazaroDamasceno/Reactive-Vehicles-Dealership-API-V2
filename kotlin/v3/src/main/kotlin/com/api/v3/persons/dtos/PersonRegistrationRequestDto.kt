package com.api.v3.persons.dtos

import java.time.LocalDate

data class PersonRegistrationRequestDto(
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val ssn: String,
    val email: String,
    val birthDate: LocalDate,
    val address: String,
    val gender: String,
    val phoneNumber: String
)

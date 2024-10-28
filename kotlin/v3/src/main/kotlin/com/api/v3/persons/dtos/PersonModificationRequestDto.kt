package com.api.v3.persons.dtos

import java.time.LocalDate

data class PersonModificationRequestDto(
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val email: String,
    val birthDate: LocalDate,
    val address: String,
    val gender: String,
    val phoneNumber: String
)

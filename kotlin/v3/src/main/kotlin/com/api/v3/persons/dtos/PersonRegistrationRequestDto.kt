package com.api.v3.persons.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class PersonRegistrationRequestDto(
    val firstName: @NotBlank String,
    val middleName: String?,
    val lastName: @NotBlank String,
    val ssn: @NotBlank @Size(min = 9, max = 9) String,
    val email: @NotBlank @Email String,
    val birthDate: LocalDate,
    val address: @NotBlank String,
    val gender: @NotBlank String,
    val phoneNumber: @NotBlank @Size(min = 10, max = 10) String
)

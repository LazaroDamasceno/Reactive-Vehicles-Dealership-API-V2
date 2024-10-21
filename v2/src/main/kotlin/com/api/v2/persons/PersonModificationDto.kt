package com.api.v2.persons

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class PersonModificationDto(
    val firstName: @NotBlank String,
    val middleName: String?,
    val lastName: @NotBlank String,
    val birthDate: LocalDate,
    val email: @NotBlank @Email String,
    val address: @NotBlank String,
    val gender: @NotBlank @Size(min=1) String,
    val phoneNumber: @NotBlank @Size(min=10, max=10) String
)

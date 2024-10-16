package com.api.v1.persons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PersonModificationRequestDto(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String lastName,
        LocalDate birthDate,
        @NotBlank @Email String email,
        @NotBlank String address,
        @NotBlank @Size(min = 10, max = 10) String phoneNumber,
        @NotBlank @Size(min = 1) String gender
) {
}

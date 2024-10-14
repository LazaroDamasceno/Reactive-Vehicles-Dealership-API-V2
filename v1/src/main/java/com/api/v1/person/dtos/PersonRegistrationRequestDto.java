package com.api.v1.person.dtos;

import com.api.v1.person.annotations.SSN;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PersonRegistrationRequestDto(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String lastName,
        @SSN String ssn,
        LocalDate birthDate,
        @NotBlank @Email String email,
        @NotBlank String address,
        @NotBlank @Size(min = 10, max = 10) String phoneNumber,
        @NotBlank @Size(min = 1) String gender
) {
}

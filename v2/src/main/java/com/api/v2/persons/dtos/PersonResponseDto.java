package com.api.v2.persons.dtos;

import com.api.v2.persons.annotations.SSN;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public record PersonResponseDto(
        @NotBlank String fullName,
        @SSN String ssn,
        @NotNull LocalDate birthDate,
        @Email @NotBlank String email,
        @NotBlank String address,
        @NotBlank @Size(min = 9, max = 9) String phoneNumber,
        @NotBlank @Size(min = 1) String gender,
        @NotNull ZonedDateTime createdAt
) {
}

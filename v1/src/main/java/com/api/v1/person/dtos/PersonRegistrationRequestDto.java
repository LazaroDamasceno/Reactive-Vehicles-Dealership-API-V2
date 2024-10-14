package com.api.v1.person.dtos;

import com.api.v1.person.annotations.SSN;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PersonRegistrationRequestDto(
        @NotBlank String firstName,
        @Nullable String middleName,
        @NotBlank String lastName,
        @SSN String ssn,
        @NotNull LocalDate birthDate,
        @Email @NotBlank String email,
        @NotBlank String address,
        @NotBlank @Size(min = 9, max = 9) String phoneNumber,
        @NotBlank @Size(min = 1) String gender
) {
}

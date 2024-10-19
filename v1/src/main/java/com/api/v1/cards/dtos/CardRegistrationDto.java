package com.api.v1.cards.dtos;

import com.api.v1.cards.annotations.CardNumber;
import com.api.v1.persons.annotations.SSN;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CardRegistrationDto(
        @CardNumber String cardNumber,
        LocalDate dueDate,
        @NotBlank @Size(min=3, max=3) String cvc,
        @NotBlank String ownerName,
        @SSN String ownerSsn
) {
}

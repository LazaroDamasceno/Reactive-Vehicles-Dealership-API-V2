package com.api.v1.card.dtos;

import com.api.v1.card.annotations.CardNumber;
import com.api.v1.persons.annotations.SSN;
import jakarta.validation.constraints.NotBlank;

public record CardRegistrationDto(
        @CardNumber String cardNumber,
        @NotBlank String ownerName,
        @SSN String ownerSsn
) {
}

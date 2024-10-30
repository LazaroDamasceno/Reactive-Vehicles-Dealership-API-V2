package com.api.v2.cards.dtos;

import com.api.v2.cards.annotations.CardNumber;
import com.api.v2.cards.utils.CardDueDate;
import com.api.v2.persons.annotations.SSN;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CardRegistrationDto(
        @CardNumber String cardNumber,
        @NotNull CardDueDate dueDate,
        @NotBlank @Size(min=3, max=3) String cvc,
        @NotBlank String ownerName,
        @SSN String ownerSsn
) {
}

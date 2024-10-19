package com.api.v1.payment_card.dtos;

import com.api.v1.payment_card.annotations.CardNumber;
import com.api.v1.persons.annotations.SSN;

public record CardRegistrationDto(
        @CardNumber String cardNumber,
        @SSN String ssn
) {
}

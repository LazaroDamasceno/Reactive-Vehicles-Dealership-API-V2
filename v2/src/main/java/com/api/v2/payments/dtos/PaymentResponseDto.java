package com.api.v2.payments.dtos;

import com.api.v2.cards.dtos.CardResponseDto;

import java.time.ZonedDateTime;
import java.util.UUID;

public record PaymentResponseDto(
        UUID paymentId,
        CardResponseDto cardResponseDto,
        double finalPrice,
        ZonedDateTime createdAt
) {
}

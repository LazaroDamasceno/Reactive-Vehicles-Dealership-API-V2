package com.api.v1.payments.dtos;

import com.api.v1.cards.dtos.CardResponseDto;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public record PaymentResponseDto(
        BigInteger orderNumber,
        double salesTax,
        double taxedAmount,
        double finalPrice,
        CardResponseDto cardResponseDto,
        ZonedDateTime createdAt
) {
}

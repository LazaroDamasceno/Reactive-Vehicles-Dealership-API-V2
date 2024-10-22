package com.api.v2.payments;

import com.api.v2.cards.dtos.CardResponseDto;
import com.api.v2.cars.dtos.CarResponseDto;

import java.time.ZonedDateTime;
import java.util.UUID;

public record PaymentResponseDto(
        UUID paymentId,
        CarResponseDto carResponseDto,
        CardResponseDto cardResponseDto,
        double finalPrice,
        ZonedDateTime createdAt
) {
}

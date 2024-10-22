package com.api.v1.payments.domain;

import com.api.v1.cards.domain.Card;
import com.api.v1.payments.utils.PaymentOrderNumberGeneratorUtil;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public record Payment(
        @Id
        UUID id,
        BigInteger orderNumber,
        double salesTax,
        double taxedAmount,
        double finalPrice,
        Card card,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static Payment of(double price, Card card) {
        final double SALES_TAX = 0.2;
        return new Payment(
                UUID.randomUUID(),
                PaymentOrderNumberGeneratorUtil.generate(),
                SALES_TAX,
                price * SALES_TAX,
                price * (1 + SALES_TAX),
                card,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

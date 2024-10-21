package com.api.v1.payments.domain;

import com.api.v1.cards.domain.Card;
import com.api.v1.cars.domain.Car;
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
        Car car,
        double salesTax,
        double taxedAmount,
        double finalPrice,
        Card card,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static Payment of(Car car, Card card) {
        final double SALES_TAX = 0.2;
        return new Payment(
                UUID.randomUUID(),
                PaymentOrderNumberGeneratorUtil.generate(),
                car,
                SALES_TAX,
                car.getVehicle().getPrice() * SALES_TAX,
                car.getVehicle().getPrice() * (1 + SALES_TAX),
                card,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

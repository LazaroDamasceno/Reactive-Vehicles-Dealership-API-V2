package com.api.v2.payments;

import com.api.v2.cards.domain.Card;
import com.api.v2.cars.domain.Car;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document
public record Payment(
    @Id
    UUID id,
    UUID paymentId,
    Car car,
    Card card,
    double salesTax,
    double taxedAmount,
    double finalPrice,
    LocalDateTime createdAt,
    ZoneId createdAtZone
) {

    public static Payment of(Car car, Card card) {
        final double SALES_TAX = 0.2;
        return new Payment(
                UUID.randomUUID(),
                UUID.randomUUID(),
                car,
                card,
                SALES_TAX,
                SALES_TAX * car.getVehicle().getPrice(),
                (1 + SALES_TAX) * car.getVehicle().getPrice(),
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

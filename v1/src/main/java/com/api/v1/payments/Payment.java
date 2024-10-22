package com.api.v1.payments;

import com.api.v1.cards.domain.Card;
import com.api.v1.cars.domain.Car;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document
public record Payment(
    @Id
    UUID id,
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

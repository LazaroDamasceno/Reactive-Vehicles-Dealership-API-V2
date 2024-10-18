package com.api.v1.cars.domain.subclasses;

import com.api.v1.cars.domain.superclass.Car;
import com.api.v1.vehicles.domain.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document
public class Sedan extends Car {

    @Id
    private UUID id;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    private Sedan(Vehicle vehicle) {
        super("Sedan", vehicle);
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Sedan of(Vehicle vehicle) {
        return new Sedan(vehicle);
    }

}
package com.api.v1.cars.domain;

import com.api.v1.vehicles.domain.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Document
public class Crossover extends Car {

    @Id
    private UUID id;

    public Crossover(Vehicle vehicle) {
        super("Crossover", vehicle);
        this.id = UUID.randomUUID();

    }

    public static Crossover of(Vehicle vehicle) {
        return new Crossover(vehicle);
    }

}

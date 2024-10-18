package com.api.v1.cars.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.api.v1.vehicles.domain.Vehicle;

@Document
public class Crossover extends Car {

    public Crossover(Vehicle vehicle) {
        super("Crossover", vehicle);
    }

    public static Crossover of(Vehicle vehicle) {
        return new Crossover(vehicle);
    }

}

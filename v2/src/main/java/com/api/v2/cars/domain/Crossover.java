package com.api.v2.cars.domain;

import com.api.v2.vehicles.domain.Vehicle;

public class Crossover extends Car {

    public Crossover(Vehicle vehicle) {
        super("Crossover", vehicle);
    }

    public static Crossover of(Vehicle vehicle) {
        return new Crossover(vehicle);
    }

}

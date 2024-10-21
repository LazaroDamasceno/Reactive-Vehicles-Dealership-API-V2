package com.api.v1.cars.domain;

import com.api.v1.vehicles.domain.Vehicle;

public class Sedan extends Car {

    private Sedan(Vehicle vehicle) {
        super("Sedan", vehicle);
    }

    public static Sedan of(Vehicle vehicle) {
        return new Sedan(vehicle);
    }

}

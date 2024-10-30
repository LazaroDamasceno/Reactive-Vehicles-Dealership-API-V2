package com.api.v2.cars.domain;

import com.api.v2.vehicles.domain.Vehicle;

public class Sedan extends Car {

    private Sedan(Vehicle vehicle) {
        super("Sedan", vehicle);
    }

    public static Sedan of(Vehicle vehicle) {
        return new Sedan(vehicle);
    }

}

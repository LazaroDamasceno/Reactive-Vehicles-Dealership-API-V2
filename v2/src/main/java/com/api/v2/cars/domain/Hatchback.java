package com.api.v2.cars.domain;

import com.api.v2.vehicles.domain.Vehicle;

public class Hatchback extends Car {

    private Hatchback(Vehicle vehicle) {
        super("Hatchback", vehicle);
    }

    public static Hatchback of(Vehicle vehicle) {
        return new Hatchback(vehicle);
    }

}

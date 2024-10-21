package com.api.v1.cars.domain;

import com.api.v1.vehicles.domain.Vehicle;

public class Pickup extends Car {

    private Pickup(Vehicle vehicle) {
        super("Pickup", vehicle);
    }

    public static Pickup of(Vehicle vehicle) {
        return new Pickup(vehicle);
    }

}

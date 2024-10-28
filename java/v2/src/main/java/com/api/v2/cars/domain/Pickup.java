package com.api.v2.cars.domain;

import com.api.v2.vehicles.domain.Vehicle;

public class Pickup extends Car {

    private Pickup(Vehicle vehicle) {
        super("Pickup", vehicle);
    }

    public static Pickup of(Vehicle vehicle) {
        return new Pickup(vehicle);
    }

}

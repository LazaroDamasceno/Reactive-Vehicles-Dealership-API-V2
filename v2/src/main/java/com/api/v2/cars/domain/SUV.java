package com.api.v2.cars.domain;

import com.api.v2.vehicles.domain.Vehicle;

public class SUV extends Car {

    private SUV(Vehicle vehicle) {
        super("SUV", vehicle);
    }

    public static SUV of(Vehicle vehicle) {
        return new SUV(vehicle);
    }

}

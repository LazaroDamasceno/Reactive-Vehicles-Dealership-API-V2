package com.api.v1.cars.domain;

import com.api.v1.vehicles.domain.Vehicle;

public class SUV extends Car {

    private SUV(Vehicle vehicle) {
        super("SUV", vehicle);
    }

    public static SUV of(Vehicle vehicle) {
        return new SUV(vehicle);
    }

}

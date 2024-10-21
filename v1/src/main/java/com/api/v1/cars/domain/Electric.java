package com.api.v1.cars.domain;

import com.api.v1.vehicles.domain.Vehicle;
public class Electric extends Car {

    private Electric(Vehicle vehicle) {
        super("Electric", vehicle);
    }

    public static Electric of(Vehicle vehicle) {
        return new Electric(vehicle);
    }

}

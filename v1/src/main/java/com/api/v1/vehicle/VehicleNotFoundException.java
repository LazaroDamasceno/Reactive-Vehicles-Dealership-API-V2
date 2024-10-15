package com.api.v1.vehicle;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
        super("Vehicle was not found.");
    }
}

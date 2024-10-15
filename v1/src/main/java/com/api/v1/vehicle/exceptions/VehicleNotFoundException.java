package com.api.v1.vehicle.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
        super("Vehicle was not found.");
    }
}

package com.api.v1.vehicle.exceptions;

public class UnavailableVehicleException extends RuntimeException {
    public UnavailableVehicleException() {
        super("The vehicle is unavailable.");
    }
}

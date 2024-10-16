package com.api.v1.vehicles.exceptions;

public class UnavailableVehicleException extends RuntimeException {
    public UnavailableVehicleException() {
        super("The vehicle is unavailable.");
    }
}

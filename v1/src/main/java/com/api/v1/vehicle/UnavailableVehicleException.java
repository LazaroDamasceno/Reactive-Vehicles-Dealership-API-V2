package com.api.v1.vehicle;

public class UnavailableVehicleException extends RuntimeException {
    public UnavailableVehicleException() {
        super("The vehicle is unavailable.");
    }
}

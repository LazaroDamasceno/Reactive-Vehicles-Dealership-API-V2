package com.api.v2.cars.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("The sought car was not found.");
    }
}

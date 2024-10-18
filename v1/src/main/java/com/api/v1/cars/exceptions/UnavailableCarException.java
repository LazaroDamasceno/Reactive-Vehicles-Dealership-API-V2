package com.api.v1.cars.exceptions;

public class UnavailableCarException extends RuntimeException {
    public UnavailableCarException() {
        super("The sought car is already sold.");
    }
}

package com.api.v2.cars.exceptions;

public class UnavailableCarException extends RuntimeException {
    public UnavailableCarException() {
        super("The sought car is already sold.");
    }
}

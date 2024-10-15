package com.api.v1.vehicle;

public class DuplicatedVinException extends RuntimeException {
    public DuplicatedVinException() {
        super("The given VIN is already registered.");
    }
}

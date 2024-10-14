package com.api.v1.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Customer was not found.");
    }
}

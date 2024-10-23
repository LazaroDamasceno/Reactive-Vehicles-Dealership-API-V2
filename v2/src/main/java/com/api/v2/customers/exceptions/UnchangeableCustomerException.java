package com.api.v2.customers.exceptions;

public class UnchangeableCustomerException extends RuntimeException {
    public UnchangeableCustomerException(String message) {
        super(message);
    }
}

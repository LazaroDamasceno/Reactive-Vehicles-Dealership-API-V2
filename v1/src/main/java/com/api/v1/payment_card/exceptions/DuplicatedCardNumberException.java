package com.api.v1.payment_card.exceptions;

public class DuplicatedCardNumberException extends RuntimeException {
    public DuplicatedCardNumberException() {
        super("The given card number is already registered.");
    }
}

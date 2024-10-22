package com.api.v2.cards.exceptions;

public class DuplicatedCardNumberException extends RuntimeException {
    public DuplicatedCardNumberException() {
        super("The given card number is already registered.");
    }
}

package com.api.v1.payment_card.exceptions;

public class CardWasNotFoundException extends RuntimeException {
    public CardWasNotFoundException() {
        super("The sought card was not found.");
    }
}

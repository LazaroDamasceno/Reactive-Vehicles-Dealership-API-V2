package com.api.v2.cards.exceptions;

public class CardWasNotFoundException extends RuntimeException {
    public CardWasNotFoundException() {
        super("The sought card was not found.");
    }
}

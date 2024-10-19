package com.api.v1.cards.utils;

public record CardDueDate(int month, int year) {

    @Override
    public String toString() {
        return "%s/%s".formatted(month, year);
    }

}

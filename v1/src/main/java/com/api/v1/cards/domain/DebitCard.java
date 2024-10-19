package com.api.v1.cards.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class DebitCard extends Card {

    private DebitCard(String number, LocalDate dueDate, String cvc, String ownerName, String ownerSsn) {
        super("Debit card", number, dueDate, cvc, ownerName, ownerSsn);
    }

    public static DebitCard of(String number, LocalDate dueDate, String cvc, String ownerName, String ownerSsn) {
        return new DebitCard(number, dueDate, cvc, ownerName, ownerSsn);
    }

}

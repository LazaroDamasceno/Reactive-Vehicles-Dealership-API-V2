package com.api.v1.cards.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class CreditCard extends Card {

    private CreditCard(String number, LocalDate dueDate, String cvc, String ownerName, String ownerSsn) {
        super("Credit card", number, dueDate, cvc, ownerName, ownerSsn);
    }

    public static CreditCard of(String number, LocalDate dueDate, String cvc, String ownerName, String ownerSsn) {
        return new CreditCard(number, dueDate, cvc, ownerName, ownerSsn);
    }

}

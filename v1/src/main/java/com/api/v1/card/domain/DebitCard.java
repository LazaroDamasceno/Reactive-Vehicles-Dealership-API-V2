package com.api.v1.card.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DebitCard extends Card {

    private DebitCard(String number, String ownerName, String ownerSsn) {
        super("Debit card", number, ownerName, ownerSsn);
    }

    public static DebitCard of(String number, String ownerName, String ownerSsn) {
        return new DebitCard(number, ownerName, ownerSsn);
    }

}

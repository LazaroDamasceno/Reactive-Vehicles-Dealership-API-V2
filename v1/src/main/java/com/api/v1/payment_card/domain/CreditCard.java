package com.api.v1.payment_card.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CreditCard extends Card {

    private CreditCard(String number, String ownerName, String ownerSsn) {
        super("Credit card", number, ownerName, ownerSsn);
    }

    public static CreditCard of(String number, String ownerName, String ownerSsn) {
        return new CreditCard(number, ownerName, ownerSsn);
    }

}

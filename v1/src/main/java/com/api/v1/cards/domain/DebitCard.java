package com.api.v1.cards.domain;

import com.api.v1.cards.utils.CardDueDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DebitCard extends Card {

    private DebitCard(String number, CardDueDate dueDate, String cvc, String ownerName, String ownerSsn) {
        super("Debit card", number, dueDate, cvc, ownerName, ownerSsn);
    }

    public static DebitCard of(String number, CardDueDate dueDate, String cvc, String ownerName, String ownerSsn) {
        return new DebitCard(number, dueDate, cvc, ownerName, ownerSsn);
    }

}

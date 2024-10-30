package com.api.v2.cards.domain;

import com.api.v2.cards.utils.CardDueDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CreditCard extends Card {

    private CreditCard(String number, CardDueDate dueDate, String cvc, String ownerName, String ownerSsn) {
        super("Credit card", number, dueDate, cvc, ownerName, ownerSsn);
    }

    public static CreditCard of(String number, CardDueDate dueDate, String cvc, String ownerName, String ownerSsn) {
        return new CreditCard(number, dueDate, cvc, ownerName, ownerSsn);
    }

}

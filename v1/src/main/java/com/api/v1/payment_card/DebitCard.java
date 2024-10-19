package com.api.v1.payment_card;

import com.api.v1.persons.domain.Person;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DebitCard extends Card {

    private DebitCard(String number, Person owner) {
        super("Debit card", number, owner);
    }

    public static DebitCard of(String number, Person owner) {
        return new DebitCard(number, owner);
    }

}

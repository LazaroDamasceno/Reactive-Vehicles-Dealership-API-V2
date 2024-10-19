package com.api.v1.payment_card;

import com.api.v1.persons.domain.Person;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CreditCard extends Card {

    private CreditCard( String number, Person owner) {
        super("Credit card", number, owner);
    }

    public static CreditCard of(String number, Person owner) {
        return new CreditCard(number, owner);
    }

}

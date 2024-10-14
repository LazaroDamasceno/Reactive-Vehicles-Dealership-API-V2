package com.api.v1.customer.domain;

import com.api.v1.person.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "v1_customers")
public class Customer {

    @Id
    private UUID id;
    private Person person;
    private Instant createdAt;
    private ZoneId createdAtZone;
    private Instant modifiedAt;
    private ZoneId modifiedAtZone;

    private Customer(Person person) {
        this.id = UUID.randomUUID();
        this.person = person;
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Customer of(Person person) {
        return new Customer(person);
    }

    public void modify(Person person) {
        this.person = person;
        modifiedAt = Instant.now();
        modifiedAtZone = ZoneId.systemDefault();
    }

}

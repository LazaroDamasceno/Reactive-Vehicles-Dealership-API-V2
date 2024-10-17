package com.api.v1.customers.domain;

import com.api.v1.persons.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    private UUID id;
    private Person person;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;
    private LocalDateTime modifiedAt;
    private ZoneId modifiedAtZone;

    private Customer(Person person) {
        this.id = UUID.randomUUID();
        this.person = person;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Customer of(Person person) {
        return new Customer(person);
    }

    public void modify(Person person) {
        this.person = person;
        modifiedAt = LocalDateTime.now();
        modifiedAtZone = ZoneId.systemDefault();
    }

}

package com.api.v2.customers.domain;

import com.api.v2.persons.domain.Person;
import com.api.v2.persons.utils.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document
public class Customer {

    @Id
    private UUID id;
    @Setter
    private Person person;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;
    private LocalDateTime bookedDeletionDate;

    private Customer(Person person) {
        this.id = UUID.randomUUID();
        this.person = person;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Customer of(Person person) {
        return new Customer(person);
    }

    public void bookDeletion() {
        this.bookedDeletionDate = LocalDateTime.now().plusYears(Constants.LEGAL_DELETION_DEADLINE);
    }

}

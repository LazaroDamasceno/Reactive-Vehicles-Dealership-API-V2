package com.api.v1.payment_card.domain;

import com.api.v1.persons.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Card {

    @Id
    private UUID id;
    private String type;
    private String number;
    private Person owner;
    private LocalDateTime createdAt;
    private ZoneId createdZoneId;

    Card(String type, String number, Person owner) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.number = number;
        this.owner = owner;
        this.createdAt = LocalDateTime.now();
        this.createdZoneId = ZoneId.systemDefault();
    }

}

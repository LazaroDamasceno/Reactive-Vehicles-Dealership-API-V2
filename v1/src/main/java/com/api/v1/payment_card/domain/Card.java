package com.api.v1.payment_card.domain;

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
    private String ownerName;
    private String ownerSsn;
    private LocalDateTime createdAt;
    private ZoneId createdZoneId;

    Card(String type, String number, String ownerName, String ownerSsn) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.number = number;
        this.ownerName = ownerName;
        this.ownerSsn = ownerSsn;
        this.createdAt = LocalDateTime.now();
        this.createdZoneId = ZoneId.systemDefault();
    }

}

package com.api.v2.persons.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document(collection = "person_audit_trail")
public record PersonAuditTrail (
    @Id
    UUID uuid,
    Person person,
    LocalDateTime createdAt,
    ZoneId createdAtZone
) {

    public static PersonAuditTrail of(Person person) {
        return new PersonAuditTrail(
                UUID.randomUUID(),
                person,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

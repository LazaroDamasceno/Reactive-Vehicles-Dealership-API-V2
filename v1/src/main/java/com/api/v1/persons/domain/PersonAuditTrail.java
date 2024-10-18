package com.api.v1.persons.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document(collection = "person_audit_trail")
public record PersonAuditTrail (
    @Id
    UUID uuid,
    PersonEntity personEntity,
    LocalDateTime createdAt,
    ZoneId createdAtZone
) {

    public static PersonAuditTrail of(PersonEntity personEntity) {
        return new PersonAuditTrail(
                UUID.randomUUID(),
                personEntity,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

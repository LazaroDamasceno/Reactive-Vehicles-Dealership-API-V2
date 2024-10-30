package com.api.v2.customers.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document
public record CustomerAuditTrail(
        @Id
        UUID id,
        Customer customer,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static CustomerAuditTrail of(Customer customer) {
        return new CustomerAuditTrail(
                UUID.randomUUID(),
                customer,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

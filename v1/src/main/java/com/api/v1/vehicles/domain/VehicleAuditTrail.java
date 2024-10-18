package com.api.v1.vehicles.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document(collection = "vehicle_audit_trail")
public record VehicleAuditTrail(
    @Id
    UUID id,
    Vehicle vehicle,
    LocalDateTime createdAt,
    ZoneId createdAtZone
) {

    public static VehicleAuditTrail of(Vehicle vehicle) {
        return new VehicleAuditTrail(
                UUID.randomUUID(),
                vehicle,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

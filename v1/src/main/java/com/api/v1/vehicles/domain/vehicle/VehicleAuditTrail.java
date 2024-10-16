package com.api.v1.vehicles.domain.vehicle;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Document(collection = "vehicle_audit_trail")
public record VehicleAuditTrail(
    @Id
    UUID id,
    Vehicle vehicle,
    Instant createdAt,
    ZoneId createdAtZone
) {

    public static VehicleAuditTrail of(Vehicle vehicle) {
        return new VehicleAuditTrail(
                UUID.randomUUID(),
                vehicle,
                Instant.now(),
                ZoneId.systemDefault()
        );
    }

}

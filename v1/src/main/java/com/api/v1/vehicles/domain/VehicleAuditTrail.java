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
    VehicleEntity vehicleEntity,
    LocalDateTime createdAt,
    ZoneId createdAtZone
) {

    public static VehicleAuditTrail of(VehicleEntity vehicleEntity) {
        return new VehicleAuditTrail(
                UUID.randomUUID(),
                vehicleEntity,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

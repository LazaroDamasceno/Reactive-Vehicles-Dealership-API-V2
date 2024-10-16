package com.api.v1.cars;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

public record CarAuditTrail(
        @Id
        UUID id,
        Vehicle car,
        Instant createdAt,
        ZoneId createdAtZone
) {

    public static CarAuditTrail of(Vehicle car) {
        return new CarAuditTrail(
                UUID.randomUUID(),
                car,
                Instant.now(),
                ZoneId.systemDefault()
        );
    }

}

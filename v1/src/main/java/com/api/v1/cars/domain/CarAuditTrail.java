package com.api.v1.cars.domain;

import com.api.v1.vehicles.domain.Vehicle;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public record CarAuditTrail(
        @Id
        UUID id,
        Vehicle car,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static CarAuditTrail of(Vehicle car) {
        return new CarAuditTrail(
                UUID.randomUUID(),
                car,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

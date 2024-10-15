package com.api.v1.vehicle.domain;

import com.api.v1.vehicle.utils.VehiclePlateNumberGeneratorUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Document(collection = "vehicle_plate_number")
public record VehiclePlateNumber(
    @Id
    UUID id,
    String plateNumber,
    Vehicle vehicle,
    Instant createdAt,
    ZoneId createdAtZone
) {

    public static VehiclePlateNumber of(Vehicle vehicle) {
        return new VehiclePlateNumber(
                UUID.randomUUID(),
                VehiclePlateNumberGeneratorUtil.generateUniquePlateNumber(),
                vehicle,
                Instant.now(),
                ZoneId.systemDefault()
        );
    }

}

package com.api.v2.vehicles.dtos;

import java.time.ZonedDateTime;

public record VehicleResponseDto(
        String model,
        String make,
        int manufacturingYear,
        ZonedDateTime createdAt
) {
}

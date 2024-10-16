package com.api.v1.cars.dtos;

import com.api.v1.vehicles.dtos.VehicleResponseDto;

import java.time.ZonedDateTime;

public record CarResponseDto(
        String type,
        VehicleResponseDto vehicleResponseDto,
        ZonedDateTime createdAt
) {
}

package com.api.v2.cars.dtos;

import com.api.v2.vehicles.dtos.VehicleResponseDto;

public record CarResponseDto(
        String type,
        String vin,
        String plateNumber,
        VehicleResponseDto vehicle
) {
}

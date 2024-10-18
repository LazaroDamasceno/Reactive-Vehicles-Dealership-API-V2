package com.api.v1.vehicles.utils;

import com.api.v1.vehicles.domain.Vehicle;
import com.api.v1.vehicles.dtos.VehicleResponseDto;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class VehicleResponseMapperUtil {

    public VehicleResponseDto map(Vehicle vehicle) {
        return new VehicleResponseDto(
                vehicle.getModel(),
                vehicle.getMake(),
                vehicle.getManufacturingYear(),
                ZonedDateTime.of(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

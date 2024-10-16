package com.api.v1.vehicles.utils;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
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
                ZonedDateTime.ofInstant(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

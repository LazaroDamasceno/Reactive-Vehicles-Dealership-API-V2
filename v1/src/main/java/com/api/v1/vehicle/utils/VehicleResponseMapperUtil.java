package com.api.v1.vehicle.utils;

import com.api.v1.vehicle.domain.Vehicle;
import com.api.v1.vehicle.dtos.VehicleResponseDto;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class VehicleResponseMapperUtil {

    public VehicleResponseDto map(Vehicle vehicle) {
        return new VehicleResponseDto(
                vehicle.getModel(),
                vehicle.getMake(),
                vehicle.getManufacturingYear(),
                vehicle.getVin(),
                ZonedDateTime.ofInstant(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

package com.api.v1.vehicles.utils;

import com.api.v1.vehicles.domain.VehicleEntity;
import com.api.v1.vehicles.dtos.VehicleResponseDto;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class VehicleResponseMapperUtil {

    public VehicleResponseDto map(VehicleEntity vehicleEntity) {
        return new VehicleResponseDto(
                vehicleEntity.getModel(),
                vehicleEntity.getMake(),
                vehicleEntity.getManufacturingYear(),
                ZonedDateTime.of(vehicleEntity.getCreatedAt(), vehicleEntity.getCreatedAtZone())
        );
    }

}

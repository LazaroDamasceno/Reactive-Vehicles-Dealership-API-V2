package com.api.v1.cars.types.utils;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarResponseMapper;
import com.api.v1.cars.types.domain.SuvEntity;
import com.api.v1.vehicles.utils.VehicleResponseMapperUtil;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class SuvResponseMapperUtil implements CarResponseMapper<SuvEntity> {

    @Override
    public CarResponseDto map(@NotNull SuvEntity vehicle) {
        return new CarResponseDto(
                vehicle.getType(),
                vehicle.getVin(),
                vehicle.getPlateNumber(),
                VehicleResponseMapperUtil.map(vehicle.getVehicleEntity()),
                ZonedDateTime.of(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

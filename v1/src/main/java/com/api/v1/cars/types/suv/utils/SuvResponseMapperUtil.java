package com.api.v1.cars.types.suv.utils;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarResponseMapper;
import com.api.v1.cars.types.suv.domain.SUV;
import com.api.v1.vehicles.utils.VehicleResponseMapperUtil;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class SuvResponseMapperUtil implements CarResponseMapper<SUV> {

    @Override
    public CarResponseDto map(@NotNull SUV vehicle) {
        return new CarResponseDto(
                vehicle.getType(),
                vehicle.getVin(),
                vehicle.getPlateNumber(),
                VehicleResponseMapperUtil.map(vehicle.getVehicle()),
                ZonedDateTime.ofInstant(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

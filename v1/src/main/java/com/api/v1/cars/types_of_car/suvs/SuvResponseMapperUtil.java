package com.api.v1.cars.types_of_car.suvs;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarResponseMapper;
import com.api.v1.vehicles.utils.VehicleResponseMapperUtil;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
class SuvResponseMapperUtil implements CarResponseMapper<SUV> {

    @Override
    public CarResponseDto map(@NotNull SUV vehicle) {
        return new CarResponseDto(
                vehicle.getType(),
                VehicleResponseMapperUtil.map(vehicle.getVehicle()),
                ZonedDateTime.ofInstant(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

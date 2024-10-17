package com.api.v1.cars.types.electric.utils;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarResponseMapper;
import com.api.v1.cars.types.electric.domain.Electric;
import com.api.v1.vehicles.utils.VehicleResponseMapperUtil;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class ElectricResponseMapperUtil implements CarResponseMapper<Electric> {

    @Override
    public CarResponseDto map(Electric vehicle) {
        return new CarResponseDto(
                vehicle.getType(),
                vehicle.getVin(),
                vehicle.getPlateNumber(),
                VehicleResponseMapperUtil.map(vehicle.getVehicle()),
                ZonedDateTime.ofInstant(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

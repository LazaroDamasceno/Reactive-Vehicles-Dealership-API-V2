package com.api.v1.cars.types.utils;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarResponseMapper;
import com.api.v1.cars.types.domain.Crossover;
import com.api.v1.vehicles.utils.VehicleResponseMapperUtil;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class CrossoverResponseMapperUtil implements CarResponseMapper<Crossover> {

    @Override
    public CarResponseDto map(Crossover vehicle) {
        return new CarResponseDto(
                vehicle.getType(),
                vehicle.getVin(),
                vehicle.getPlateNumber(),
                VehicleResponseMapperUtil.map(vehicle.getVehicle()),
                ZonedDateTime.of(vehicle.getCreatedAt(), vehicle.getCreatedAtZone())
        );
    }

}

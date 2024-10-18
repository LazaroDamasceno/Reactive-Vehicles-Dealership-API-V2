package com.api.v1.cars.utils;

import com.api.v1.cars.Car;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.utils.VehicleResponseMapperUtil;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarResponseMapperUtil {

    public CarResponseDto map(Car car) {
        return new CarResponseDto(
                car.getType(),
                car.getVin(),
                car.getPlateNumber(),
                VehicleResponseMapperUtil.map(car.getVehicle())
        );
    }

}

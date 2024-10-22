package com.api.v2.cars.utils;

import com.api.v2.cars.domain.Car;
import com.api.v2.cars.dtos.CarResponseDto;
import com.api.v2.vehicles.utils.VehicleResponseMapperUtil;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

@UtilityClass
public class CarResponseMapperUtil {

    public CarResponseDto mapToDto(Car car) {
        return new CarResponseDto(
                car.getType(),
                car.getVin(),
                car.getPlateNumber(),
                VehicleResponseMapperUtil.map(car.getVehicle())
        );
    }

    public Mono<CarResponseDto> mapToMono(Car car) {
        return Mono.just(mapToDto(car));
    }

}

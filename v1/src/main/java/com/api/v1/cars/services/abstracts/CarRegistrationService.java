package com.api.v1.cars.services.abstracts;

import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleRegistrationService;
import reactor.core.publisher.Mono;

public abstract class CarRegistrationService {

    protected final VehicleRegistrationService vehicleRegistrationService;
    protected final CarRepository carRepository;

    public CarRegistrationService(
            VehicleRegistrationService vehicleRegistrationService,
            CarRepository carRepository
    ) {
        this.vehicleRegistrationService = vehicleRegistrationService;
        this.carRepository = carRepository;
    }

    public abstract Mono<CarResponseDto> register(VehicleRegistrationRequestDto requestDto);

}

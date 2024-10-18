package com.api.v1.cars.services.cars;

import com.api.v1.cars.domain.repository.CarRepository;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleRegistrationService;
import reactor.core.publisher.Mono;

public abstract class CarRegistrationService {

    protected VehicleRegistrationService vehicleRegistrationService;
    protected CarRepository carRepository;

    public CarRegistrationService(
            VehicleRegistrationService vehicleRegistrationService,
            CarRepository carRepository
    ) {
        this.vehicleRegistrationService = vehicleRegistrationService;
        this.carRepository = carRepository;
    }

    public abstract Mono<CarResponseDto> register(VehicleRegistrationRequestDto requestDto);

}

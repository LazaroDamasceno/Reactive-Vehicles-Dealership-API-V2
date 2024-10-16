package com.api.v1.cars.services;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface CarRegistrationService {

    Mono<Vehicle> register(VehicleRegistrationRequestDto requestDto);

}

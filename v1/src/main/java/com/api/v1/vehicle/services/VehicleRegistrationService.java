package com.api.v1.vehicle.services;

import com.api.v1.vehicle.domain.vehicle.Vehicle;
import com.api.v1.vehicle.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface VehicleRegistrationService {

    Mono<Vehicle> register(VehicleRegistrationRequestDto requestDto);

}

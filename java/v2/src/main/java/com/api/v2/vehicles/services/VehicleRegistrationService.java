package com.api.v2.vehicles.services;

import com.api.v2.vehicles.domain.Vehicle;
import com.api.v2.vehicles.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface VehicleRegistrationService {

    Mono<Vehicle> register(VehicleRegistrationRequestDto requestDto);

}

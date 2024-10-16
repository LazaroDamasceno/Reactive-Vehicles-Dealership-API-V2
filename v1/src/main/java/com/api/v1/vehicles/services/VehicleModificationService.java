package com.api.v1.vehicles.services;

import com.api.v1.vehicles.domain.Vehicle;
import com.api.v1.vehicles.dtos.VehicleModificationRequestDto;
import reactor.core.publisher.Mono;

public interface VehicleModificationService {

    Mono<Vehicle> modify(Vehicle vehicle, VehicleModificationRequestDto requestDto);

}

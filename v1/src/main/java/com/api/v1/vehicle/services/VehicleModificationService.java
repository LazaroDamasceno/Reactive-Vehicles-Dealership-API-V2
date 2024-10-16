package com.api.v1.vehicle.services;

import com.api.v1.vehicle.domain.vehicle.Vehicle;
import com.api.v1.vehicle.dtos.VehicleModificationRequestDto;
import reactor.core.publisher.Mono;

public interface VehicleModificationService {

    Mono<Vehicle> modify(Vehicle vehicle, VehicleModificationRequestDto requestDto);

}

package com.api.v1.vehicles.services;

import com.api.v1.vehicles.domain.VehicleEntity;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface VehicleRegistrationService {

    Mono<VehicleEntity> register(VehicleRegistrationRequestDto requestDto);

}

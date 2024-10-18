package com.api.v1.cars;

import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface CrossoverRegistrationService {

    Mono<CarResponseDto> register(VehicleRegistrationRequestDto requestDto);

}

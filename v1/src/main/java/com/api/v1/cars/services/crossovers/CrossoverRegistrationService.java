package com.api.v1.cars.services.crossovers;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface CrossoverRegistrationService {

    Mono<CarResponseDto> register(VehicleRegistrationRequestDto requestDto);

}

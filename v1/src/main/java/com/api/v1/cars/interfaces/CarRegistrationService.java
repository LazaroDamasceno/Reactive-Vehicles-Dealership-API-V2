package com.api.v1.cars.interfaces;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface CarRegistrationService {

    Mono<CarResponseDto> register(VehicleRegistrationRequestDto requestDto);

}

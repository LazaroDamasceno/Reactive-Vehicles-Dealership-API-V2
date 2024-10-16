package com.api.v1.cars.generics;

import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface CarRegistrationService<T> {

    Mono<T> register(VehicleRegistrationRequestDto requestDto);

}

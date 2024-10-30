package com.api.v2.cars.services;

import com.api.v2.cars.dtos.CarResponseDto;
import reactor.core.publisher.Flux;

public interface CarRetrievalService {

    Flux<CarResponseDto> findAll();

}

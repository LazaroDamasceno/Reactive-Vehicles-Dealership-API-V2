package com.api.v1.cars;

import reactor.core.publisher.Flux;

public interface CarRetrievalService {

    Flux<CarResponseDto> findAll();

}

package com.api.v1.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class CarRetrievalServiceImpl implements CarRetrievalService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Flux<CarResponseDto> findAll() {
        return carRepository
                .findAll()
                .flatMap(CarResponseMapperUtil::mapToMono);
    }

}

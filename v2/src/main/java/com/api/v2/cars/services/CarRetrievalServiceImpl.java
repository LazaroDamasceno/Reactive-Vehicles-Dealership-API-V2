package com.api.v2.cars.services;

import com.api.v2.cars.domain.CarRepository;
import com.api.v2.cars.dtos.CarResponseDto;
import com.api.v2.cars.utils.CarResponseMapperUtil;
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

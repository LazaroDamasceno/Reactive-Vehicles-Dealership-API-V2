package com.api.v1.cars.utils;

import com.api.v1.cars.exceptions.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.v1.cars.domain.Car;
import com.api.v1.cars.domain.CarRepository;
import com.api.v1.vehicles.annotations.VIN;

import reactor.core.publisher.Mono;

@Component
public class CarFinderUtil {
    
    @Autowired
    private CarRepository carRepository;

    public Mono<Car> findByVin(@VIN String vin) {
        return carRepository
                .findByVin(vin)
                .single()
                .switchIfEmpty(Mono.error(CarNotFoundException::new));
    }

}

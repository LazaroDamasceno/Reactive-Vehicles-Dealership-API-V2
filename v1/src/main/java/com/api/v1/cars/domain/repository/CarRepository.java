package com.api.v1.cars.domain.repository;

import com.api.v1.cars.domain.superclass.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface CarRepository extends ReactiveMongoRepository<Car, UUID> {
}

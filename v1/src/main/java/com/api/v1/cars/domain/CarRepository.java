package com.api.v1.cars.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CarRepository extends ReactiveMongoRepository<Car, UUID> {

    @Query("{ 'vin': ?0 }")
    Mono<Car> findByVin(String vin);

}

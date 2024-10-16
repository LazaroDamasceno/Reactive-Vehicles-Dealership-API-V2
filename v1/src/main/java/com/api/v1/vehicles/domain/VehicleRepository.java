package com.api.v1.vehicles.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface VehicleRepository extends ReactiveMongoRepository<Vehicle, UUID> {

    @Query("""
        { 'model': ?0 },
        { 'make': ?1 },
        { 'manufacturingYear': ?2 }
    """)
    Mono<Vehicle> findByModelAndMakeAndYear(String model, String make, int manufacturingYear);

}

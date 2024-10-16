package com.api.v1.vehicle.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface VehicleRepository extends ReactiveMongoRepository<Vehicle, UUID> {
}
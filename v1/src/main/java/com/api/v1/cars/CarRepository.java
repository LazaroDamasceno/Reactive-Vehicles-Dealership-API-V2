package com.api.v1.cars;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface CarRepository extends ReactiveMongoRepository<Vehicle, UUID> {
}

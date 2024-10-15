package com.api.v1.vehicle.plate_number;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface VehiclePlateNumberRepository extends ReactiveMongoRepository<VehiclePlateNumber, UUID> {
}

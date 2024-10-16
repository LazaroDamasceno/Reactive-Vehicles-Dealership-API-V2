package com.api.v1.vehicles.domain.inventory;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface VehicleInventoryRepository extends ReactiveMongoRepository<VehicleInventory, UUID> {
}

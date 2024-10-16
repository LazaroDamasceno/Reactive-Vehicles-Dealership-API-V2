package com.api.v1.vehicles.domain.inventory;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface VehicleInventoryRepository extends ReactiveMongoRepository<VehicleInventory, UUID> {

    @Query("{ 'vehicle': ?0 }")
    Mono<VehicleInventory> findByVehicle(Vehicle vehicle);

}

package com.api.v1.vehicles.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface VehicleAuditTrailRepository extends ReactiveMongoRepository<VehicleAuditTrail, UUID> {
}

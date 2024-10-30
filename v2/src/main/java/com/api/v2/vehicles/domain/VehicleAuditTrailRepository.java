package com.api.v2.vehicles.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface VehicleAuditTrailRepository extends ReactiveMongoRepository<VehicleAuditTrail, UUID> {
}

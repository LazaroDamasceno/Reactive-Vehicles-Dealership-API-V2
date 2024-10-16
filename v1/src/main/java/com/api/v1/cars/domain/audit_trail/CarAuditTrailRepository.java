package com.api.v1.cars.domain.audit_trail;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface CarAuditTrailRepository extends ReactiveMongoRepository<CarAuditTrail, UUID> {
}

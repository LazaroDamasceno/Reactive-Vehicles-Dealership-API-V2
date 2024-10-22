package com.api.v2.customers.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface CustomerAuditTrailRepository extends ReactiveMongoRepository<CustomerAuditTrail, UUID> {
}

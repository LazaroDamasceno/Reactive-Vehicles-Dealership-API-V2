package com.api.v1.persons.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface PersonAuditTrailRepository extends ReactiveMongoRepository<PersonAuditTrail, UUID> {
}

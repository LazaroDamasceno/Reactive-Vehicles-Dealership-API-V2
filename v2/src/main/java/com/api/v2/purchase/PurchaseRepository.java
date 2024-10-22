package com.api.v2.purchase;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface PurchaseRepository extends ReactiveMongoRepository<Purchase, UUID> {
}

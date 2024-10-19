package com.api.v1.purchases;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.UUID;

public interface PurchaseRepository extends ReactiveMongoRepository<Purchase, UUID> {

    @Query("{ 'orderNumber': ?0 }")
    Mono<Purchase> findByOrderNumber(BigInteger orderNumber);
}

package com.api.v1.purchases.car_purchases;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.UUID;

public interface PurchaseRepository extends ReactiveMongoRepository<CarPurchase, UUID> {

    @Query("{ 'orderNumber': ?0 }")
    Mono<CarPurchase> findByOrderNumber(BigInteger orderNumber);
}

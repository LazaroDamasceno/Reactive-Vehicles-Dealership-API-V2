package com.api.v1.payments.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.UUID;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, UUID> {

    @Query("{ 'orderNumber': ?0 }")
    Mono<Payment> findByOrderNumber(BigInteger orderNumber);

}

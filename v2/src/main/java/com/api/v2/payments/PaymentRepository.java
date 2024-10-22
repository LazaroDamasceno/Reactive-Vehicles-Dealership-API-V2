package com.api.v2.payments;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, UUID> {
}

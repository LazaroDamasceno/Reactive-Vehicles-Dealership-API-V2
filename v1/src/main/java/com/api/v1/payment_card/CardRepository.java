package com.api.v1.payment_card;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CardRepository extends ReactiveMongoRepository<Card, UUID> {

    @Query("{ 'number': ?0 }")
    Mono<Card> findByNumber(String number);

}

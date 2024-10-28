package com.api.v2.payments.services;

import com.api.v2.cards.domain.Card;
import com.api.v2.cars.domain.Car;
import com.api.v2.payments.domain.Payment;
import reactor.core.publisher.Mono;

public interface PaymentRegistrationService {

    Mono<Payment> register(Car car, Card card);

}

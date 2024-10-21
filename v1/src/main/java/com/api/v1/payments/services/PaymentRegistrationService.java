package com.api.v1.payments.services;

import com.api.v1.payments.domain.Payment;
import reactor.core.publisher.Mono;

public interface PaymentRegistrationService {

    Mono<Payment> register(String vin, String cardNumber);

}

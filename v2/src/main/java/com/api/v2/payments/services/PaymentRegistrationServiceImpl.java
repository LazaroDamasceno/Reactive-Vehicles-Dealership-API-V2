package com.api.v2.payments.services;

import com.api.v2.cards.domain.Card;
import com.api.v2.cars.domain.Car;
import com.api.v2.payments.domain.Payment;
import com.api.v2.payments.domain.PaymentRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class PaymentRegistrationServiceImpl implements PaymentRegistrationService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Mono<Payment> register(@NotNull Car car, @NotNull Card card) {
        return Mono.defer(() -> {
           Payment payment = Payment.of(car, card);
           return paymentRepository.save(payment);
        });
    }

}

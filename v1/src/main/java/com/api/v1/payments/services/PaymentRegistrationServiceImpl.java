package com.api.v1.payments.services;

import com.api.v1.cards.annotations.CardNumber;
import com.api.v1.cards.utils.CardFinderUtil;
import com.api.v1.cars.utils.CarFinderUtil;
import com.api.v1.payments.domain.Payment;
import com.api.v1.payments.domain.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class PaymentRegistrationServiceImpl implements PaymentRegistrationService {

    @Autowired
    private CarFinderUtil carFinderUtil;

    @Autowired
    private CardFinderUtil cardFinderUtil;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Mono<Payment> register(double price, @CardNumber String cardNumber) {
        var cardMono = cardFinderUtil.find(cardNumber);
        return cardMono.flatMap(card -> {
                    Payment payment = Payment.of(price, card);
                    return paymentRepository.save(payment);
                });
    }

}

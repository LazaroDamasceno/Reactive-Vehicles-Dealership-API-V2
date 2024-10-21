package com.api.v1.payments.services;

import com.api.v1.cards.annotations.CardNumber;
import com.api.v1.cards.domain.Card;
import com.api.v1.cards.utils.CardFinderUtil;
import com.api.v1.cars.domain.Car;
import com.api.v1.cars.utils.CarFinderUtil;
import com.api.v1.payments.domain.Payment;
import com.api.v1.payments.domain.PaymentRepository;
import com.api.v1.payments.utils.PaymentResponseMapperUtil;
import com.api.v1.vehicles.annotations.VIN;
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
    public Mono<Payment> register(@VIN String vin, @CardNumber String cardNumber) {
        var carMono = carFinderUtil.findByVin(vin);
        var cardMono = cardFinderUtil.find(cardNumber);
        return Mono
                .zip(carMono, cardMono)
                .flatMap(tuple -> {
                    Car car = tuple.getT1();
                    Card card = tuple.getT2();
                    Payment payment = Payment.of(car, card);
                    return paymentRepository.save(payment);
                });
    }

}

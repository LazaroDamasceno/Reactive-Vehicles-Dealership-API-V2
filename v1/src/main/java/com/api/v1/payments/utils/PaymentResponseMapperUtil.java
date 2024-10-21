package com.api.v1.payments.utils;

import com.api.v1.cards.utils.CardResponseMapper;
import com.api.v1.payments.domain.Payment;
import com.api.v1.payments.dtos.PaymentResponseDto;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

@UtilityClass
public class PaymentResponseMapperUtil {

    public PaymentResponseDto mapToDto(Payment payment) {
        return new PaymentResponseDto(
                payment.orderNumber(),
                payment.salesTax(),
                payment.taxedAmount(),
                payment.finalPrice(),
                CardResponseMapper.mapToDto(payment.card()),
                ZonedDateTime.of(payment.createdAt(), payment.createdAtZone())
        );
    }

    public Mono<PaymentResponseDto> mapToMono(Payment payment) {
        return Mono.just(mapToDto(payment));
    }

}

package com.api.v2.payments.utils;

import com.api.v2.cards.utils.CardResponseMapperUtil;
import com.api.v2.cars.utils.CarResponseMapperUtil;
import com.api.v2.payments.domain.Payment;
import com.api.v2.payments.dtos.PaymentResponseDto;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class PaymentResponseMapperUtil {

    public PaymentResponseDto mapToDto(Payment payment) {
         return new PaymentResponseDto(
                 payment.paymentId(),
                 CarResponseMapperUtil.mapToDto(payment.car()),
                 CardResponseMapperUtil.mapToDto(payment.card()),
                 payment.finalPrice(),
                 ZonedDateTime.of(payment.createdAt(), payment.createdAtZone())
         );
    }

}

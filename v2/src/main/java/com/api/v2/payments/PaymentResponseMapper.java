package com.api.v2.payments;

import com.api.v2.cards.utils.CardResponseMapperUtil;
import com.api.v2.cars.utils.CarResponseMapperUtil;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class PaymentResponseMapper {

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

package com.api.v2.purchase.utils;

import com.api.v2.cards.utils.CardResponseMapperUtil;
import com.api.v2.cars.utils.CarResponseMapperUtil;
import com.api.v2.customers.utils.CustomerResponseMapperUtil;
import com.api.v2.employees.utils.EmployeeResponseMapperUtil;
import com.api.v2.payments.utils.PaymentResponseMapperUtil;
import com.api.v2.purchase.Purchase;
import com.api.v2.purchase.dtos.PurchaseResponseDto;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class PurchaseResponseMapper {

    public PurchaseResponseDto mapToDto(Purchase purchase) {
        return new PurchaseResponseDto(
                CustomerResponseMapperUtil.mapToDto(purchase.customer()),
                EmployeeResponseMapperUtil.mapToDto(purchase.salesperson()),
                CarResponseMapperUtil.mapToDto(purchase.car()),
                CardResponseMapperUtil.mapToDto(purchase.card()),
                PaymentResponseMapperUtil.mapToDto(purchase.payment()),
                ZonedDateTime.of(purchase.createdAt(), purchase.createdAtZone())
        );
    }

}

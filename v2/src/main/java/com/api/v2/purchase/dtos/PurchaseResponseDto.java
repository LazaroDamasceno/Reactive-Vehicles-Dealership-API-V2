package com.api.v2.purchase.dtos;

import com.api.v2.cards.dtos.CardResponseDto;
import com.api.v2.cars.dtos.CarResponseDto;
import com.api.v2.customers.dtos.CustomerResponseDto;
import com.api.v2.employees.dtos.EmployeeResponseDto;
import com.api.v2.payments.dtos.PaymentResponseDto;

import java.time.ZonedDateTime;

public record PurchaseResponseDto(
        CustomerResponseDto customerResponseDto,
        EmployeeResponseDto employeeResponseDto,
        CarResponseDto carResponseDto,
        CardResponseDto cardResponseDto,
        PaymentResponseDto paymentResponseDto,
        ZonedDateTime createdAt
) {
}

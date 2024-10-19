package com.api.v1.purchases.car_purchases.dtos;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.employees.dtos.EmployeeResponseDto;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public record CarPurchaseResponseDto(
        BigInteger orderNumber,
        CustomerResponseDto customerResponseDto,
        EmployeeResponseDto salesperson,
        CarResponseDto carResponseDto,
        ZonedDateTime createdAt
) {
}

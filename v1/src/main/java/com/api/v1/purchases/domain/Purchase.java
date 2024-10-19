package com.api.v1.purchases.domain;

import com.api.v1.customers.domain.Customer;
import com.api.v1.employees.domain.Employee;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public record Purchase(
        @Id
        UUID id,
        BigInteger orderNumber,
        Customer customer,
        Employee salesperson,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {
}

package com.api.v1.purchases;

import com.api.v1.cars.domain.Car;
import com.api.v1.customers.domain.Customer;
import com.api.v1.employees.domain.Employee;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document
public record Purchase(
        @Id
        UUID id,
        BigInteger orderNumber,
        Customer customer,
        Employee salesperson,
        Car car,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static Purchase of(Customer customer, Employee salesperson, Car car) {
        return new Purchase(
                UUID.randomUUID(),
                PurchaseOrderNumberGeneratorUtil.generate(),
                customer,
                salesperson,
                car,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

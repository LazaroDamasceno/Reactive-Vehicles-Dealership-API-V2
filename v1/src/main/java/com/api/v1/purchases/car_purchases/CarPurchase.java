package com.api.v1.purchases.car_purchases;

import com.api.v1.cars.domain.Car;
import com.api.v1.customers.domain.Customer;
import com.api.v1.employees.domain.Employee;
import com.api.v1.employees.domain.Salesperson;
import com.api.v1.purchases.utils.PurchaseOrderNumberGeneratorUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document
public record CarPurchase(
        @Id
        UUID id,
        BigInteger orderNumber,
        Customer customer,
        Employee salesperson,
        Car car,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static CarPurchase of(Customer customer, Salesperson salesperson, Car car) {
        return new CarPurchase(
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

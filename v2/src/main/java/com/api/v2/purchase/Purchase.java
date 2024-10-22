package com.api.v2.purchase;

import com.api.v2.cards.domain.Card;
import com.api.v2.cars.domain.Car;
import com.api.v2.customers.domain.Customer;
import com.api.v2.employees.domain.Employee;
import com.api.v2.payments.domain.Payment;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public record Purchase(
        @Id
        UUID id,
        Customer customer,
        Employee salesperson,
        Car car,
        Card card,
        Payment payment,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static Purchase of(
            Customer customer,
            Employee salesperson,
            Car car,
            Card card,
            Payment payment
    ) {
        return new Purchase(
                UUID.randomUUID(),
                customer,
                salesperson,
                car,
                card,
                payment,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}

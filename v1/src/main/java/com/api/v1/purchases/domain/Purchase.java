package com.api.v1.purchases.domain;

import com.api.v1.cars.domain.Car;
import com.api.v1.customers.domain.Customer;
import com.api.v1.employees.domain.Employee;
import com.api.v1.employees.domain.Salesperson;
import com.api.v1.purchases.utils.PurchaseOrderNumberGeneratorUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class  Purchase {

        @Id
        private UUID id;
        private BigInteger orderNumber;
        private Customer customer;
        private Employee salesperson;
        private Car car;
        private LocalDateTime createdAt;
        private ZoneId createdAtZone;

        Purchase(Customer customer, Employee salesperson, Car car) {
                this.id = UUID.randomUUID();
                this.orderNumber = PurchaseOrderNumberGeneratorUtil.generate();
                this.car = car;
                this.customer = customer;
                this.salesperson = salesperson;
                this.createdAt = LocalDateTime.now();
                this.createdAtZone = ZoneId.systemDefault();
        }

}

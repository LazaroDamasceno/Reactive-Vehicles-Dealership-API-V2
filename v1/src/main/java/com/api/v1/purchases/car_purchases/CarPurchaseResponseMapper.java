package com.api.v1.purchases.car_purchases;

import com.api.v1.cars.utils.CarResponseMapperUtil;
import com.api.v1.customers.utils.CustomerResponseMapperUtil;
import com.api.v1.employees.utils.EmployeeResponseMapperUtil;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

@UtilityClass
public class CarPurchaseResponseMapper {

    public CarPurchaseResponseDto mapToDto(CarPurchase purchase) {
        return new CarPurchaseResponseDto(
                purchase.orderNumber(),
                CustomerResponseMapperUtil.map(purchase.customer()),
                EmployeeResponseMapperUtil.mapToDto(purchase.salesperson()),
                CarResponseMapperUtil.map(purchase.car()),
                ZonedDateTime.of(purchase.createdAt(), purchase.createdAtZone())
        );
    }

    public Mono<CarPurchaseResponseDto> mapToMono(CarPurchase purchase) {
        return Mono.just(mapToDto(purchase));
    }

}

package com.api.v1.purchases.utils;

import com.api.v1.cars.utils.CarResponseMapperUtil;
import com.api.v1.customers.utils.CustomerResponseMapperUtil;
import com.api.v1.employees.utils.EmployeeResponseMapperUtil;
import com.api.v1.purchases.domain.CarPurchase;
import com.api.v1.purchases.domain.Purchase;
import com.api.v1.purchases.dtos.CarPurchaseDto;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

@UtilityClass
public class CarPurchaseMapperUtil {

    public CarPurchaseDto mapToDto(Purchase purchase) {
        return new CarPurchaseDto(
                purchase.getOrderNumber(),
                CustomerResponseMapperUtil.mapToDto(purchase.getCustomer()),
                EmployeeResponseMapperUtil.mapToDto(purchase.getSalesperson()),
                CarResponseMapperUtil.mapToDto(purchase.getCar()),
                ZonedDateTime.of(purchase.getCreatedAt(), purchase.getCreatedAtZone())
        );
    }

    public Mono<CarPurchaseDto> mapToMono(CarPurchase purchase) {
        return Mono.just(mapToDto(purchase));
    }

}

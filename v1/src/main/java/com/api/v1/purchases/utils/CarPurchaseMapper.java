package com.api.v1.purchases.utils;

import com.api.v1.cars.utils.CarResponseMapperUtil;
import com.api.v1.customers.utils.CustomerResponseMapperUtil;
import com.api.v1.employees.utils.EmployeeResponseMapperUtil;
import com.api.v1.purchases.domain.CarPurchase;
import com.api.v1.purchases.dtos.CarPurchaseDto;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class CarPurchaseMapper {

    public CarPurchaseDto map(CarPurchase purchase) {
        return new CarPurchaseDto(
                purchase.getOrderNumber(),
                CustomerResponseMapperUtil.mapToDto(purchase.getCustomer()),
                EmployeeResponseMapperUtil.mapToDto(purchase.getSalesperson()),
                CarResponseMapperUtil.mapToDto(purchase.getCar()),
                ZonedDateTime.of(purchase.getCreatedAt(), purchase.getCreatedAtZone())
        );
    }

}

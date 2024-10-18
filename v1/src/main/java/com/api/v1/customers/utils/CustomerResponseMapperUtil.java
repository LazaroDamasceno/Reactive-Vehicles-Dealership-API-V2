package com.api.v1.customers.utils;

import com.api.v1.customers.domain.CustomerEntity;
import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.persons.utils.PersonResponseMapperUtil;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class CustomerResponseMapperUtil {

    public CustomerResponseDto map(CustomerEntity customerEntity) {
        return new CustomerResponseDto(
                PersonResponseMapperUtil.mapToDto(customerEntity.getPersonEntity()),
                ZonedDateTime.of(customerEntity.getCreatedAt(), customerEntity.getCreatedAtZone())
        );
    }

}

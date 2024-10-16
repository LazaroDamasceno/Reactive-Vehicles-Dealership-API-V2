package com.api.v1.customers.utils;

import com.api.v1.customers.domain.Customer;
import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.persons.utils.PersonResponseMapperUtil;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class CustomerResponseMapperUtil {

    public CustomerResponseDto map(Customer customer) {
        return new CustomerResponseDto(
                PersonResponseMapperUtil.mapToDto(customer.getPerson()),
                ZonedDateTime.ofInstant(customer.getCreatedAt(), customer.getCreatedAtZone())
        );
    }

}

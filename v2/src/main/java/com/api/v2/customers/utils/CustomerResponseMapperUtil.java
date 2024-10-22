package com.api.v2.customers.utils;

import com.api.v2.customers.domain.Customer;
import com.api.v2.customers.dtos.CustomerResponseDto;
import com.api.v2.persons.utils.PersonResponseMapperUtil;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class CustomerResponseMapperUtil {

    public CustomerResponseDto mapToDto(Customer customer) {
        return new CustomerResponseDto(
                PersonResponseMapperUtil.mapToDto(customer.getPerson()),
                ZonedDateTime.of(customer.getCreatedAt(), customer.getCreatedAtZone())
        );
    }

}

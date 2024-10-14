package com.api.v1.customer.utils;

import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.person.utils.PersonResponseMapperUtil;
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

package com.api.v3.customers.utils

import com.api.v3.customers.domain.Customer
import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.persons.utils.PersonResponseMapper
import java.time.ZonedDateTime

class CustomerResponseMapper {

    companion object {
        fun map(customer: Customer): CustomerResponseDto {
            return CustomerResponseDto(
                PersonResponseMapper.map(customer.person),
                ZonedDateTime.of(customer.createdAt, customer.createdAtZone)
            )
        }
    }

}
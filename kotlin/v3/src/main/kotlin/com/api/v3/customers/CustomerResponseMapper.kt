package com.api.v3.customers

import com.api.v3.persons.utls.PersonResponseMapper
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
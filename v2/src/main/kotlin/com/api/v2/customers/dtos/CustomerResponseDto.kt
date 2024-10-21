package com.api.v2.customers.dtos

import com.api.v2.persons.dtos.PersonResponseDto

data class CustomerResponseDto(
    val isActive: Boolean,
    val personResponseDto: PersonResponseDto
)

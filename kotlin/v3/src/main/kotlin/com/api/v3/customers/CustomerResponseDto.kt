package com.api.v3.customers

import com.api.v3.persons.dtos.PersonResponseDto
import java.time.ZonedDateTime

data class CustomerResponseDto(
    val personResponseDto: PersonResponseDto,
    val createdAt: ZonedDateTime
)

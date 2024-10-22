package com.api.v2.customers.dtos;

import com.api.v2.persons.dtos.PersonResponseDto;

import java.time.ZonedDateTime;

public record CustomerResponseDto(
        PersonResponseDto responseDto,
        ZonedDateTime createdAt
) {
}

package com.api.v1.customers.dtos;

import com.api.v1.persons.dtos.PersonResponseDto;

import java.time.ZonedDateTime;

public record CustomerResponseDto(
        PersonResponseDto responseDto,
        ZonedDateTime createdAt
) {
}

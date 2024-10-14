package com.api.v1.customer;

import com.api.v1.person.dtos.PersonResponseDto;

import java.time.ZonedDateTime;

public record CustomerResponseDto(
        PersonResponseDto responseDto,
        ZonedDateTime createdAt
) {
}

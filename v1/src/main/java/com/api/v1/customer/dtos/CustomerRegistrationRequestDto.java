package com.api.v1.customer.dtos;

import com.api.v1.person.dtos.PersonRegistrationRequestDto;

public record CustomerRegistrationRequestDto(
        PersonRegistrationRequestDto requestDto
) {
}

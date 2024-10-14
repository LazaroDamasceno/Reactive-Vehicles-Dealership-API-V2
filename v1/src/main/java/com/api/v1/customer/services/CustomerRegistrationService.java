package com.api.v1.customer.services;

import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerRegistrationService {

    Mono<CustomerResponseDto> register(PersonRegistrationRequestDto requestDto);

}

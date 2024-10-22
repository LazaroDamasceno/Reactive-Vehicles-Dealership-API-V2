package com.api.v2.customers.services;

import com.api.v2.customers.dtos.CustomerResponseDto;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerRegistrationService {

    Mono<CustomerResponseDto> register(PersonRegistrationRequestDto requestDto);

}

package com.api.v1.customers.services;

import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerModificationService {

    Mono<CustomerResponseDto> modify(String ssn, PersonModificationRequestDto requestDto);

}

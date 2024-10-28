package com.api.v2.customers.services;

import com.api.v2.customers.dtos.CustomerResponseDto;
import com.api.v2.persons.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerModificationService {

    Mono<CustomerResponseDto> modify(String ssn, PersonModificationRequestDto requestDto);

}

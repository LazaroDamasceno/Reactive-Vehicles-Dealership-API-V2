package com.api.v1.customer.services;

import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.person.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerModificationService {

    Mono<CustomerResponseDto> modify(String ssn, PersonModificationRequestDto requestDto);

}

package com.api.v2.customers.services;

import com.api.v2.customers.dtos.CustomerResponseDto;
import reactor.core.publisher.Flux;

public interface CustomerRetrievalService {

    Flux<CustomerResponseDto> findAll();

}

package com.api.v1.customers.services;

import com.api.v1.customers.dtos.CustomerResponseDto;
import reactor.core.publisher.Flux;

public interface CustomerRetrievalService {

    Flux<CustomerResponseDto> findAll();

}

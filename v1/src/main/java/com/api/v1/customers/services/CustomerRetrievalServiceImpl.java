package com.api.v1.customers.services;

import com.api.v1.customers.domain.CustomerRepository;
import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.customers.utils.CustomerResponseMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class CustomerRetrievalServiceImpl implements CustomerRetrievalService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<CustomerResponseDto> findAll() {
        return customerRepository
                .findAll()
                .flatMap(customer -> Mono.just(CustomerResponseMapperUtil.mapToDto(customer)));
    }

}

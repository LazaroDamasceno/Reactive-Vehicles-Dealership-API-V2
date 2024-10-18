package com.api.v1.employees.services;

import com.api.v1.employees.dtos.EmployeeResponseDto;
import reactor.core.publisher.Flux;

public interface EmployeeRetrievalService {

    Flux<EmployeeResponseDto> findAll();

}

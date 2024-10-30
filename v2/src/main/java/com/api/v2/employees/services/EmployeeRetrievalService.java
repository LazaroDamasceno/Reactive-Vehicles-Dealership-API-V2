package com.api.v2.employees.services;

import com.api.v2.employees.dtos.EmployeeResponseDto;
import reactor.core.publisher.Flux;

public interface EmployeeRetrievalService {

    Flux<EmployeeResponseDto> findAll();

}

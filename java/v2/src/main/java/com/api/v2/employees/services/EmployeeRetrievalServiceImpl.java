package com.api.v2.employees.services;

import com.api.v2.employees.domain.EmployeeRepository;
import com.api.v2.employees.dtos.EmployeeResponseDto;
import com.api.v2.employees.utils.EmployeeResponseMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class EmployeeRetrievalServiceImpl implements EmployeeRetrievalService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Flux<EmployeeResponseDto> findAll() {
        return employeeRepository
                .findAll()
                .flatMap(EmployeeResponseMapperUtil::mapToMono);
    }

}

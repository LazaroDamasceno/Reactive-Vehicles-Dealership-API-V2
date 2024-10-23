package com.api.v2.employees.services;

import com.api.v2.employees.annotations.EmployeeId;
import com.api.v2.employees.domain.EmployeeRepository;
import com.api.v2.employees.utils.EmployeeFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class EmployeeTerminationServiceImpl implements EmployeeTerminationService {

    @Autowired
    private EmployeeFinderUtil employeeFinderUtil;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<Void> terminate(@EmployeeId String employeeId) {
        return employeeFinderUtil
                .find(employeeId)
                .flatMap(employee -> {
                    employee.terminate();
                    return employeeRepository.save(employee);
                })
                .then();
    }

}

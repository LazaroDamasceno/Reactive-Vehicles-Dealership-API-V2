package com.api.v1.employees.services;

import com.api.v1.employees.domain.EmployeeEntity;
import com.api.v1.employees.domain.EmployeeRepository;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import com.api.v1.persons.services.PersonModificationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class EmployeeModificationServiceImpl implements EmployeeModificationService {

    @Autowired
    private PersonModificationService personModificationService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeEntity> modify(@NotNull EmployeeEntity employeeEntity, @Valid PersonModificationRequestDto requestDto) {
        return personModificationService
                .modify(employeeEntity.getPersonEntity(), requestDto)
                .flatMap(person -> {
                    employeeEntity.setPersonEntity(person);
                    return employeeRepository.save(employeeEntity);
                });
    }

}

package com.api.v1.employees;

import com.api.v1.persons.dtos.PersonRegistrationRequestDto;
import com.api.v1.persons.services.PersonRegistrationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SalespersonRegistrationServiceImpl extends EmployeeRegistrationService {

    public SalespersonRegistrationServiceImpl(
            PersonRegistrationService personRegistrationService,
            EmployeeRepository employeeRepository
    ) {
        super(personRegistrationService, employeeRepository);
    }

    @Override
    public Mono<EmployeeResponseDto> register(@Valid PersonRegistrationRequestDto requestDto) {
        return personRegistrationService
                .register(requestDto)
                .flatMap(person -> employeeRepository.save(Salesperson.of(person)))
                .flatMap(EmployeeResponseMapperUtil::mapToMono);
    }

}

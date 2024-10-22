package com.api.v2.employees.services.salesperson;

import com.api.v2.employees.domain.EmployeeRepository;
import com.api.v2.employees.domain.Salesperson;
import com.api.v2.employees.dtos.EmployeeResponseDto;
import com.api.v2.employees.services.abstracts.EmployeeRegistrationService;
import com.api.v2.employees.utils.EmployeeResponseMapperUtil;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import com.api.v2.persons.services.PersonRegistrationService;
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

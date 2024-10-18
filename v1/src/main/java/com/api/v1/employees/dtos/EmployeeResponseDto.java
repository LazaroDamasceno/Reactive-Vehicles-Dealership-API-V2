package com.api.v1.employees.dtos;

import com.api.v1.persons.dtos.PersonResponseDto;

public record EmployeeResponseDto(
        String type,
        PersonResponseDto personResponseDto
) {
}

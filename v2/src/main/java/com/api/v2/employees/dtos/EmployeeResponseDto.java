package com.api.v2.employees.dtos;

import com.api.v2.persons.dtos.PersonResponseDto;

public record EmployeeResponseDto(
        String type,
        PersonResponseDto personResponseDto
) {
}

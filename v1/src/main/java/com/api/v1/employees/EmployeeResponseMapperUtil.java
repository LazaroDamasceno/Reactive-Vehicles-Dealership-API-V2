package com.api.v1.employees;

import com.api.v1.persons.utils.PersonResponseMapperUtil;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

@UtilityClass
public class EmployeeResponseMapperUtil {

    public EmployeeResponseDto mapToDto(Employee employee) {
        return new EmployeeResponseDto(
                employee.getType(),
                PersonResponseMapperUtil.mapToDto(employee.getPerson())
        );
    }

    public Mono<EmployeeResponseDto> mapToMono(Employee employee) {
        return Mono.just(mapToDto(employee));
    }

}

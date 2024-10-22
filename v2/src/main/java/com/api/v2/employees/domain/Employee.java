package com.api.v2.employees.domain;

import com.api.v2.employees.utils.EmployeeIdGeneratorUtil;
import com.api.v2.persons.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Employee {

    @Id
    private UUID id;
    private String type;
    private String employeeId;
    @Setter
    private Person person;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    Employee(String type, Person person) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.employeeId = EmployeeIdGeneratorUtil.generate();
        this.person = person;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

}

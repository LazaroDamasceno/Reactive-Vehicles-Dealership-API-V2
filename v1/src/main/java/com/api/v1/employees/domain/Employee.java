package com.api.v1.employees.domain;

import com.api.v1.employees.utils.EmployeeIdGeneratorUtil;
import com.api.v1.persons.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {

    @Id
    private UUID id;
    private Person person;
    private String EmployeeId;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    private Employee(Person person) {
        this.id = UUID.randomUUID();
        this.person = person;
        EmployeeId = EmployeeIdGeneratorUtil.generateEmployeeId();
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Employee of(Person person) {
        return new Employee(person);
    }

}

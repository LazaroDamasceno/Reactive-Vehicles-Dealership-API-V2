package com.api.v1.employees;

import com.api.v1.persons.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private Person person;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    Employee(String type, Person person) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.person = person;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

}

package com.api.v1.employees.domain;

import com.api.v1.employees.utils.EmployeeIdGeneratorUtil;
import com.api.v1.persons.domain.PersonEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "employee")
public class EmployeeEntity {

    @Id
    private UUID id;
    @Setter
    private PersonEntity personEntity;
    private String EmployeeId;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    private EmployeeEntity(PersonEntity personEntity) {
        this.id = UUID.randomUUID();
        this.personEntity = personEntity;
        EmployeeId = EmployeeIdGeneratorUtil.generateEmployeeId();
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static EmployeeEntity of(PersonEntity personEntity) {
        return new EmployeeEntity(personEntity);
    }

}

package com.api.v1.customers.domain;

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
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private UUID id;
    @Setter
    private PersonEntity personEntity;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    private CustomerEntity(PersonEntity personEntity) {
        this.id = UUID.randomUUID();
        this.personEntity = personEntity;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static CustomerEntity of(PersonEntity personEntity) {
        return new CustomerEntity(personEntity);
    }

}

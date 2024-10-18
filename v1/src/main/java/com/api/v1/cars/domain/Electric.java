package com.api.v1.cars.domain;

import com.api.v1.vehicles.domain.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document
public class Electric extends Car {

    @Id
    private UUID id;

    private Electric(Vehicle vehicle) {
        super("Electric", vehicle);
        this.id = UUID.randomUUID();
    }

    public static Electric of(Vehicle vehicle) {
        return new Electric(vehicle);
    }

}

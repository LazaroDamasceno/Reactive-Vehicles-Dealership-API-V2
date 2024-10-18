package com.api.v1.cars;

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
@Document(collection = "crossover_car")
public class CrossoverCar extends Car {

    @Id
    private UUID id;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    public CrossoverCar(Vehicle vehicle) {
        super("Crossover", vehicle);
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static CrossoverCar of(Vehicle vehicle) {
        return new CrossoverCar(vehicle);
    }

}

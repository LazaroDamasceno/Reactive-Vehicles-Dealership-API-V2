package com.api.v1.cars.domain.minvan;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "minivan")
public class Minivan extends Vehicle {

    @Id
    private UUID id;
    private String type;
    private Vehicle vehicle;
    private Instant createdAt;
    private ZoneId createdAtZone;
    private Instant modifiedAt;
    private ZoneId modifiedAtZone;

    private Minivan(Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.type = "Minivan";
        this.vehicle = vehicle;
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Minivan of(Vehicle vehicle) {
        return new Minivan(vehicle);
    }

    public void modify(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.modifiedAt = Instant.now();
        this.modifiedAtZone = ZoneId.systemDefault();
    }

}

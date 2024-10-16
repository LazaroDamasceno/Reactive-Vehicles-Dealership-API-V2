package com.api.v1.cars.domain.covertable;

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
@Document(collection = "vehicle")
public class Convertible extends Vehicle {

    @Id
    private UUID id;
    private String type;
    private Vehicle vehicle;
    private Instant createdAt;
    private ZoneId createdAtZone;
    private Instant modifiedAt;
    private ZoneId modifiedAtZone;

    private Convertible(Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.type = "Convertible";
        this.vehicle = vehicle;
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Convertible of(Vehicle vehicle) {
        return new Convertible(vehicle);
    }

    public void modify(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.modifiedAt = Instant.now();
        this.modifiedAtZone = ZoneId.systemDefault();
    }

}

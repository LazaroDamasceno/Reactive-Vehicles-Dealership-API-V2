package com.api.v1.cars.domain.sedan;

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
@Document(collection = "sedan")
public class Sedan extends Vehicle {

    @Id
    private UUID id;
    private String type;
    private Vehicle vehicle;
    private Instant createdAt;
    private ZoneId createdAtZone;
    private Instant modifiedAt;
    private ZoneId modifiedAtZone;

    private Sedan(Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.type = "Sedan";
        this.vehicle = vehicle;
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Sedan of(Vehicle vehicle) {
        return new Sedan(vehicle);
    }

    public void modify(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.modifiedAt = Instant.now();
        this.modifiedAtZone = ZoneId.systemDefault();
    }

}

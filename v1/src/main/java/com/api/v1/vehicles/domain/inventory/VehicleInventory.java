package com.api.v1.vehicles.domain.inventory;

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
@Document(collection = "vehicle_inventory")
public class VehicleInventory {

    @Id
    private UUID id;
    private Vehicle vehicle;
    private int quantityAvailable;
    private int quantitySold;
    private Instant createdAt;
    private ZoneId createdAtZone;

    public VehicleInventory(Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.vehicle = vehicle;
        this.quantityAvailable = 0;
        this.quantitySold = 0;
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public void increaseAvailableQuantity() {
        this.quantityAvailable += 1;
    }

}

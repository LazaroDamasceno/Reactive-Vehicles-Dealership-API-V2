package com.api.v1.vehicle.domain;

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
    private String plateNumber;
    private Vehicle vehicle;
    private int quantityAvailable;
    private int quantitySold;
    private Instant createdAt;
    private ZoneId createdAtZone;

}

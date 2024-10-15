package com.api.v1.vehicle.plate_number;

import com.api.v1.vehicle.vehicle.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "vehicle_plate_number")
public class VehiclePlateNumber {

    @Id
    private UUID id;
    private String plateNumber;
    private Vehicle vehicle;
    private Instant createdAt;
    private ZoneId createdAtZone;

}

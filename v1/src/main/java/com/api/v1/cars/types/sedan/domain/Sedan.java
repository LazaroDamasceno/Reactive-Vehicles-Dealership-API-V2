package com.api.v1.cars.types.sedan.domain;

import com.api.v1.cars.Car;
import com.api.v1.vehicles.domain.Vehicle;
import com.api.v1.vehicles.utils.VehiclePlateNumberGeneratorUtil;
import com.api.v1.vehicles.utils.VehicleVinGeneratorUtil;
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
public class Sedan extends Car {

    @Id
    private UUID id;
    private String type;
    private Vehicle vehicle;
    private String plateNumber;
    private String vin;
    private Instant createdAt;
    private ZoneId createdAtZone;

    private Sedan(Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.type = "Sedan";
        this.vehicle = vehicle;
        this.plateNumber = VehiclePlateNumberGeneratorUtil.generate();
        this.vin = VehicleVinGeneratorUtil.generate();
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Sedan of(Vehicle vehicle) {
        return new Sedan(vehicle);
    }

}

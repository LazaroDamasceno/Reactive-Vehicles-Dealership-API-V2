package com.api.v1.cars.types.electric.domain;

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
@Document(collection = "electric")
public class Electric extends Car {

    @Id
    private UUID id;
    private String type;
    private String vin;
    private String plateNumber;
    private Vehicle vehicle;
    private Instant createdAt;
    private ZoneId createdAtZone;

    private Electric(Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.type = "Crossover";
        this.vin = VehicleVinGeneratorUtil.generate();
        this.plateNumber = VehiclePlateNumberGeneratorUtil.generate();
        this.vehicle = vehicle;
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Electric of(Vehicle vehicle) {
        return new Electric(vehicle);
    }

}

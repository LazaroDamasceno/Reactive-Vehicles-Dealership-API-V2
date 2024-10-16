package com.api.v1.cars.types_of_car.suvs;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
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
@Document(collection = "suv")
public class SUV extends Vehicle {

    @Id
    private UUID id;
    private String type;
    private Vehicle vehicle;
    private String plateNumber;
    private String vin;
    private Instant createdAt;
    private ZoneId createdAtZone;
    private Instant modifiedAt;
    private ZoneId modifiedAtZone;

    private SUV(Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.type = "SUV";
        this.plateNumber = VehiclePlateNumberGeneratorUtil.generate();
        this.vin = VehicleVinGeneratorUtil.generate();
        this.vehicle = vehicle;
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static SUV of(Vehicle vehicle) {
        return new SUV(vehicle);
    }

    public void modify(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.modifiedAt = Instant.now();
        this.modifiedAtZone = ZoneId.systemDefault();
    }

}

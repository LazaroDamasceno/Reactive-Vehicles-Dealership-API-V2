package com.api.v2.cars.domain;

import com.api.v2.vehicles.domain.Vehicle;
import com.api.v2.vehicles.utils.VehiclePlateNumberGeneratorUtil;
import com.api.v2.vehicles.utils.VehicleVinGeneratorUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document
@NoArgsConstructor
@Getter
public class Car {

    @Id
    private UUID id;
    private String type;
    private String vin;
    private String plateNumber;
    private Vehicle vehicle;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;
    private LocalDateTime soldAt;
    private ZoneId soldAtZone;

    Car(String type, Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.vin = VehicleVinGeneratorUtil.generate();
        this.plateNumber = VehiclePlateNumberGeneratorUtil.generate();
        this.vehicle = vehicle;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public void markAsSold() {
        this.soldAt = LocalDateTime.now();
        this.soldAtZone = ZoneId.systemDefault();
    }

}

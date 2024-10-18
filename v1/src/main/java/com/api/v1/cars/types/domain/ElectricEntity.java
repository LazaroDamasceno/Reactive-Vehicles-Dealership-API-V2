package com.api.v1.cars.types.domain;

import com.api.v1.cars.Car;
import com.api.v1.vehicles.domain.VehicleEntity;
import com.api.v1.vehicles.utils.VehiclePlateNumberGeneratorUtil;
import com.api.v1.vehicles.utils.VehicleVinGeneratorUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "electric")
public class ElectricEntity extends Car {

    @Id
    private UUID id;
    private String type;
    private String vin;
    private String plateNumber;
    private VehicleEntity vehicleEntity;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    private ElectricEntity(VehicleEntity vehicleEntity) {
        this.id = UUID.randomUUID();
        this.type = "Crossover";
        this.vin = VehicleVinGeneratorUtil.generate();
        this.plateNumber = VehiclePlateNumberGeneratorUtil.generate();
        this.vehicleEntity = vehicleEntity;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static ElectricEntity of(VehicleEntity vehicleEntity) {
        return new ElectricEntity(vehicleEntity);
    }

}

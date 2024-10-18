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
@Document(collection = "suv")
public class SuvEntity extends Car {

    @Id
    private UUID id;
    private String type;
    private VehicleEntity vehicleEntity;
    private String plateNumber;
    private String vin;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    private SuvEntity(VehicleEntity vehicleEntity) {
        this.id = UUID.randomUUID();
        this.type = "SUV";
        this.plateNumber = VehiclePlateNumberGeneratorUtil.generate();
        this.vin = VehicleVinGeneratorUtil.generate();
        this.vehicleEntity = vehicleEntity;
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static SuvEntity of(VehicleEntity vehicleEntity) {
        return new SuvEntity(vehicleEntity);
    }

}

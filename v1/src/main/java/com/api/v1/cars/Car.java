package com.api.v1.cars;

import com.api.v1.vehicles.domain.Vehicle;
import com.api.v1.vehicles.utils.VehiclePlateNumberGeneratorUtil;
import com.api.v1.vehicles.utils.VehicleVinGeneratorUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Car {

    private String type;
    private String vin;
    private String plateNumber;
    private Vehicle vehicle;

    public Car(String type, Vehicle vehicle) {
        this.type = type;
        this.vin = VehicleVinGeneratorUtil.generate();
        this.plateNumber = VehiclePlateNumberGeneratorUtil.generate();
        this.vehicle = vehicle;
    }

}

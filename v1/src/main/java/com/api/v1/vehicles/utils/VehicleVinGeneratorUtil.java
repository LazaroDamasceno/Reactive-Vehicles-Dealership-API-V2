package com.api.v1.vehicles.utils;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@UtilityClass
public class VehicleVinGeneratorUtil {

    private final int VIN_LENGTH = 17;
    private final Random random = new Random();
    private final Set<Long> generatedVINS = new HashSet<>();

    public String generate() {
        while (true) {
            Long vin = generateRandomVIN();
            if (generatedVINS.add(vin)) {
                return vin.toString();
            }
        }
    }

    private Long generateRandomVIN() {
        long vin = 0;
        for (int i = 0; i < VIN_LENGTH; i++) {
            vin = (vin << 4) | random.nextInt(16);
        }
        return vin;
    }

}

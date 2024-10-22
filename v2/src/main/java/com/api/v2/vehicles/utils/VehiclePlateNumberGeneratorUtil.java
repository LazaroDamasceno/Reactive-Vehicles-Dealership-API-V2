package com.api.v2.vehicles.utils;

import lombok.experimental.UtilityClass;
import java.util.*;

@UtilityClass
public class VehiclePlateNumberGeneratorUtil {

    private final int NUM_DIGITS = 4;
    private final int NUM_LETTERS = 3;
    private final Random random = new Random();
    private final Set<String> generatedPlateNumbers = new HashSet<>();

    public String generate() {
        while (true) {
            String plateNumber = generatePlateNumber();
            if (generatedPlateNumbers.add(plateNumber)) {
                return plateNumber;
            }
        }
    }

    private String generatePlateNumber() {
        StringBuilder plateNumber = new StringBuilder();
        plateNumber.append(random.nextInt(10));
        for (int i = 0; i < NUM_LETTERS; i++) {
            plateNumber.append((char) ('A' + random.nextInt(26)));
        }
        for (int i = 0; i < NUM_DIGITS; i++) {
            plateNumber.append(random.nextInt(10));
        }
        return plateNumber.toString();
    }

}
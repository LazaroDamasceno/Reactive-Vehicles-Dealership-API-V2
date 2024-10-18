package com.api.v1.employees;

import lombok.experimental.UtilityClass;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@UtilityClass
public class EmployeeIdGeneratorUtil {

    private static final Random RANDOM = new Random();
    private static final Set<Integer> GENERATED_IDS = new ConcurrentSkipListSet<>();

    public static int generateId() {
        int id;
        do {
            id = RANDOM.nextInt(9_000_000) + 1_000_000; // Generate a 7-digit random number
        } while (!GENERATED_IDS.add(id)); // Ensure uniqueness
        return id;
    }
}
package com.api.v1.salesperson;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class EmployeeIdGeneratorUtil {

    private final Random random = new Random();
    private final Set<Integer> usedIds = new HashSet<>();

    public int generateEmployeeId() {
        int id;
        do {
            id = random.nextInt(9999999); // 7 digits
        } while (!usedIds.add(id));
        return id;
    }

}
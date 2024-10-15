package com.api.v1.vehicle.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "v1_vehicle")
public class Vehicle {

    @Id
    private UUID id;
    private String model;
    private String make;
    private int manufacturingYear;
    private String vin;
    private Instant createdAt;
    private ZoneId createdAtZone;
    private Instant modifiedAt;
    private ZoneId modifiedAtZone;

}

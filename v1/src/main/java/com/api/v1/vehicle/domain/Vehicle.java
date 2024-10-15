package com.api.v1.vehicle.domain;

import com.api.v1.vehicle.dtos.VehicleModificationRequestDto;
import com.api.v1.vehicle.dtos.VehicleRegistrationRequestDto;
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
    private Instant createdAt;
    private ZoneId createdAtZone;
    private Instant modifiedAt;
    private ZoneId modifiedAtZone;

    private Vehicle(VehicleRegistrationRequestDto requestDto) {
        this.id = UUID.randomUUID();
        this.model = requestDto.model();
        this.make = requestDto.make();
        this.manufacturingYear = requestDto.manufacturingYear();
        this.createdAt = Instant.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Vehicle of(VehicleRegistrationRequestDto requestDto) {
        return new Vehicle(requestDto);
    }

    public void modify(VehicleModificationRequestDto requestDto) {
        this.model = requestDto.model();
        this.make = requestDto.make();
        this.manufacturingYear = requestDto.manufacturingYear();
        this.modifiedAt = Instant.now();
        this.modifiedAtZone = ZoneId.systemDefault();
    }

}

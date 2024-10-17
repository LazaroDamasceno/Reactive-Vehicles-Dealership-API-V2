package com.api.v1.vehicles.domain;

import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "vehicle")
public class Vehicle {

    @Id
    private UUID id;
    private String model;
    private String make;
    private int manufacturingYear;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;

    private Vehicle(VehicleRegistrationRequestDto requestDto) {
        this.id = UUID.randomUUID();
        this.model = requestDto.model();
        this.make = requestDto.make();
        this.manufacturingYear = requestDto.manufacturingYear();
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Vehicle of(VehicleRegistrationRequestDto requestDto) {
        return new Vehicle(requestDto);
    }

}

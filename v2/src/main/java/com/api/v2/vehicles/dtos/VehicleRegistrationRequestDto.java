package com.api.v2.vehicles.dtos;

import jakarta.validation.constraints.NotBlank;

public record VehicleRegistrationRequestDto(
        @NotBlank String model,
        @NotBlank String make,
        double price,
        int manufacturingYear
) {
}

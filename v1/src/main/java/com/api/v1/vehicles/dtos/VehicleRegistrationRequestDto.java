package com.api.v1.vehicles.dtos;

import jakarta.validation.constraints.NotBlank;

public record VehicleRegistrationRequestDto(
        @NotBlank String model,
        @NotBlank String make,
        int manufacturingYear
) {
}

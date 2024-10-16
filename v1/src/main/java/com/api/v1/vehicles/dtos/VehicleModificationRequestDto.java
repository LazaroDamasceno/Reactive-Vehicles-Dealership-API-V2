package com.api.v1.vehicles.dtos;

import jakarta.validation.constraints.NotBlank;

public record VehicleModificationRequestDto(
        @NotBlank String model,
        @NotBlank String make,
        int manufacturingYear
) {
}

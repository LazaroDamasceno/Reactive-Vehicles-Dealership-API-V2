package com.api.v1.vehicle.dtos;

import jakarta.validation.constraints.NotBlank;

public record VehicleModificationRequestDto(
        @NotBlank String model,
        @NotBlank String make,
        int manufacturingYear
) {
}

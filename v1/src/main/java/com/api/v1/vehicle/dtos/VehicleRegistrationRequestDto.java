package com.api.v1.vehicle.dtos;

import com.api.v1.vehicle.annotations.VIN;
import jakarta.validation.constraints.NotBlank;

public record VehicleRegistrationRequestDto(
        @NotBlank String model,
        @NotBlank String make,
        int manufacturingYear,
        @VIN String vin
) {
}

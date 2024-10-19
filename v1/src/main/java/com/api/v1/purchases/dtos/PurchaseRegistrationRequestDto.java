package com.api.v1.purchases.dtos;

import com.api.v1.employees.annotations.EmployeeId;
import com.api.v1.persons.annotations.SSN;
import com.api.v1.vehicles.annotations.VIN;

public record PurchaseRegistrationRequestDto(
        @SSN String ssn,
        @EmployeeId String employeeId,
        @VIN String vin
) {
}

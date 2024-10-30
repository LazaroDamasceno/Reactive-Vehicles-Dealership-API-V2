package com.api.v2.purchase.dtos;

import com.api.v2.cards.annotations.CardNumber;
import com.api.v2.employees.annotations.EmployeeId;
import com.api.v2.persons.annotations.SSN;
import com.api.v2.vehicles.annotations.VIN;

public record PurchaseRegistrationRequestDto(
        @SSN String ssn,
        @EmployeeId String employeeId,
        @VIN String vin,
        @CardNumber String cardNumber
) {
}

package com.api.v1.purchases.services.abstracts;

import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.utils.CarFinderUtil;
import com.api.v1.customers.utils.CustomerFinderUtil;
import com.api.v1.employees.utils.EmployeeFinderUtil;
import com.api.v1.purchases.domain.PurchaseRepository;
import com.api.v1.purchases.dtos.CarPurchaseDto;
import com.api.v1.purchases.dtos.PurchaseRegistrationRequestDto;
import reactor.core.publisher.Mono;

public abstract class PurchaseRegistrationService {

    protected final CustomerFinderUtil customerFinderUtil;
    protected final EmployeeFinderUtil employeeFinderUtil;
    protected final CarFinderUtil carFinderUtil;
    protected final CarRepository carRepository;
    protected final PurchaseRepository purchaseRepository;

    public PurchaseRegistrationService(
            CustomerFinderUtil customerFinderUtil,
            EmployeeFinderUtil employeeFinderUtil,
            CarFinderUtil carFinderUtil,
            CarRepository carRepository,
            PurchaseRepository purchaseRepository
    ) {
        this.customerFinderUtil = customerFinderUtil;
        this.employeeFinderUtil = employeeFinderUtil;
        this.carFinderUtil = carFinderUtil;
        this.carRepository = carRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public abstract Mono<CarPurchaseDto> register(PurchaseRegistrationRequestDto requestDto);

}

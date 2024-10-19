package com.api.v1.purchases.services.abstracts;

import com.api.v1.cars.utils.CarFinderUtil;
import com.api.v1.customers.utils.CustomerFinderUtil;
import com.api.v1.employees.utils.EmployeeFinderUtil;

public abstract class PurchaseRegistrationService {

    protected final CustomerFinderUtil customerFinderUtil;
    protected final EmployeeFinderUtil employeeFinderUtil;
    protected final CarFinderUtil carFinderUtil;

    public PurchaseRegistrationService(
            CustomerFinderUtil customerFinderUtil,
            EmployeeFinderUtil employeeFinderUtil,
            CarFinderUtil carFinderUtil
    ) {
        this.customerFinderUtil = customerFinderUtil;
        this.employeeFinderUtil = employeeFinderUtil;
        this.carFinderUtil = carFinderUtil;
    }

}

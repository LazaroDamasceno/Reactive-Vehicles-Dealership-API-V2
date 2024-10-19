package com.api.v1.purchases.services.cars;

import com.api.v1.cars.domain.Car;
import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.exceptions.UnavailableCarException;
import com.api.v1.cars.utils.CarFinderUtil;
import com.api.v1.customers.domain.Customer;
import com.api.v1.customers.utils.CustomerFinderUtil;
import com.api.v1.employees.domain.Employee;
import com.api.v1.employees.utils.EmployeeFinderUtil;
import com.api.v1.purchases.domain.CarPurchase;
import com.api.v1.purchases.domain.PurchaseRepository;
import com.api.v1.purchases.dtos.CarPurchaseDto;
import com.api.v1.purchases.dtos.PurchaseRegistrationRequestDto;
import com.api.v1.purchases.services.abstracts.PurchaseRegistrationService;
import com.api.v1.purchases.utils.CarPurchaseMapperUtil;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CarPurchaseRegistrationServiceImpl extends PurchaseRegistrationService {

    public CarPurchaseRegistrationServiceImpl(
            CustomerFinderUtil customerFinderUtil,
            EmployeeFinderUtil employeeFinderUtil,
            CarFinderUtil carFinderUtil,
            CarRepository carRepository,
            PurchaseRepository purchaseRepository
    ) {
        super(customerFinderUtil, employeeFinderUtil, carFinderUtil, carRepository, purchaseRepository);
    }

    @Override
    public Mono<CarPurchaseDto> register(@Valid PurchaseRegistrationRequestDto requestDto) {
        return Mono.zip(
                    customerFinderUtil.find(requestDto.ssn()),
                    employeeFinderUtil.find(requestDto.employeeId()),
                    carFinderUtil.findByVin(requestDto.vin())
                )
                .flatMap(tuple -> {
                    Customer customer = tuple.getT1();
                    Employee employee = tuple.getT2();
                    Car car = tuple.getT3();
                    if (car.getSoldAt() != null) {
                        return Mono.error(UnavailableCarException::new);
                    }
                    car.markAsSold();
                    return carRepository
                            .save(car)
                            .then(Mono.defer(() -> purchaseRepository
                                    .save(CarPurchase.of(customer, employee, car))
                                    .flatMap(CarPurchaseMapperUtil::mapToMono))
                            );
                });
    }

}

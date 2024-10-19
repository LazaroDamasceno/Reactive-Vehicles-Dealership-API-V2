package com.api.v1.purchases.services.cars;

import com.api.v1.cars.utils.CarFinderUtil;
import com.api.v1.customers.utils.CustomerFinderUtil;
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
            PurchaseRepository purchaseRepository
    ) {
        super(customerFinderUtil, employeeFinderUtil, carFinderUtil, purchaseRepository);
    }

    @Override
    public Mono<CarPurchaseDto> register(@Valid PurchaseRegistrationRequestDto requestDto) {
        return Mono.zip(
                    customerFinderUtil.find(requestDto.ssn()),
                    employeeFinderUtil.find(requestDto.employeeId()),
                    carFinderUtil.findByVin(requestDto.vin())
                )
                .flatMap(tuple -> purchaseRepository.save(CarPurchase.of(tuple.getT1(), tuple.getT2(), tuple.getT3())))
                .flatMap(CarPurchaseMapperUtil::mapToMono);
    }

}

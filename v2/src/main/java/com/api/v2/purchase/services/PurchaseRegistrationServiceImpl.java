package com.api.v2.purchase.services;

import com.api.v2.cards.domain.Card;
import com.api.v2.cards.utils.CardFinderUtil;
import com.api.v2.cars.domain.Car;
import com.api.v2.cars.domain.CarRepository;
import com.api.v2.cars.utils.CarFinderUtil;
import com.api.v2.customers.domain.Customer;
import com.api.v2.customers.utils.CustomerFinderUtil;
import com.api.v2.employees.domain.Employee;
import com.api.v2.employees.utils.EmployeeFinderUtil;
import com.api.v2.payments.services.PaymentRegistrationService;
import com.api.v2.purchase.domain.Purchase;
import com.api.v2.purchase.domain.PurchaseRepository;
import com.api.v2.purchase.dtos.PurchaseRegistrationRequestDto;
import com.api.v2.purchase.dtos.PurchaseResponseDto;
import com.api.v2.purchase.utils.PurchaseResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class PurchaseRegistrationServiceImpl implements PurchaseRegistrationService {

    private final CustomerFinderUtil customerFinderUtil;
    private final EmployeeFinderUtil employeeFinderUtil;
    private final CarFinderUtil carFinderUtil;
    private final CardFinderUtil cardFinderUtil;
    private final PaymentRegistrationService paymentRegistrationService;
    private final PurchaseRepository purchaseRepository;
    private final CarRepository carRepository;

    @Override
    public Mono<PurchaseResponseDto> register(@Valid PurchaseRegistrationRequestDto requestDto) {
        return Mono.zip(
                customerFinderUtil.find(requestDto.ssn()),
                employeeFinderUtil.find(requestDto.employeeId()),
                carFinderUtil.find(requestDto.vin()),
                cardFinderUtil.find(requestDto.cardNumber())
        ).flatMap(tuple -> {
            Customer customer = tuple.getT1();
            Employee salesperson = tuple.getT2();
            Card card = tuple.getT4();
            Car car = tuple.getT3();
            car.markAsSold();
            return carRepository
                    .save(car)
                    .flatMap(soldCar -> paymentRegistrationService
                        .register(car, card)
                        .flatMap(payment -> {
                            Purchase purchase = Purchase.of(customer, salesperson, car, card, payment);
                            return purchaseRepository
                                    .save(purchase)
                                   .flatMap(PurchaseResponseMapper::mapToMono);
                    }));
        });
    }

}

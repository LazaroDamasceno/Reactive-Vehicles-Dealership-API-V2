package com.api.v1.purchases.controllers;

import com.api.v1.purchases.domain.Purchase;
import com.api.v1.purchases.domain.PurchaseRepository;
import com.api.v1.purchases.dtos.CarPurchaseDto;
import com.api.v1.purchases.dtos.PurchaseRegistrationRequestDto;
import com.api.v1.purchases.services.cars.CarPurchaseRegistrationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final CarPurchaseRegistrationServiceImpl carPurchaseRegistrationService;
    private final PurchaseRepository purchaseRepository;

    @PostMapping("car")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarPurchaseDto> register(@Valid @RequestBody PurchaseRegistrationRequestDto requestDto) {
        return carPurchaseRegistrationService.register(requestDto);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

}

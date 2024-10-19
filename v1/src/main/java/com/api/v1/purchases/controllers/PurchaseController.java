package com.api.v1.purchases.controllers;

import com.api.v1.purchases.dtos.CarPurchaseDto;
import com.api.v1.purchases.dtos.PurchaseRegistrationRequestDto;
import com.api.v1.purchases.services.cars.CarPurchaseRegistrationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final CarPurchaseRegistrationServiceImpl carPurchaseRegistrationService;

    @PostMapping("car")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarPurchaseDto> register(@Valid @RequestBody PurchaseRegistrationRequestDto requestDto) {
        return carPurchaseRegistrationService.register(requestDto);
    }

}

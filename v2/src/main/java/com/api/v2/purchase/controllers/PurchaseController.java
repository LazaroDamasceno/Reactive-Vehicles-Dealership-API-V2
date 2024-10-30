package com.api.v2.purchase.controllers;

import com.api.v2.purchase.dtos.PurchaseRegistrationRequestDto;
import com.api.v2.purchase.dtos.PurchaseResponseDto;
import com.api.v2.purchase.services.PurchaseRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v2/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseRegistrationService purchaseRegistrationService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<PurchaseResponseDto> register(@Valid @RequestBody PurchaseRegistrationRequestDto requestDto) {
        return purchaseRegistrationService.register(requestDto);
    }

}

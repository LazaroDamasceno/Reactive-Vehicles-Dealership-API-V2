package com.api.v2.purchase.services;

import com.api.v2.purchase.dtos.PurchaseRegistrationRequestDto;
import com.api.v2.purchase.dtos.PurchaseResponseDto;
import reactor.core.publisher.Mono;

public interface PurchaseRegistrationService {

    Mono<PurchaseResponseDto> register(PurchaseRegistrationRequestDto requestDto);

}

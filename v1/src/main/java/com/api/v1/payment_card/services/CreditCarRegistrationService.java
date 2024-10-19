package com.api.v1.payment_card.services;

import com.api.v1.payment_card.dtos.CardRegistrationDto;
import com.api.v1.payment_card.dtos.CardResponseDto;
import reactor.core.publisher.Mono;

public interface CreditCarRegistrationService {

    Mono<CardResponseDto> register(CardRegistrationDto registrationDto);

}

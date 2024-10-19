package com.api.v1.card.services.credit_card;

import com.api.v1.card.dtos.CardRegistrationDto;
import com.api.v1.card.dtos.CardResponseDto;
import reactor.core.publisher.Mono;

public interface CreditCarRegistrationService {

    Mono<CardResponseDto> register(CardRegistrationDto registrationDto);

}

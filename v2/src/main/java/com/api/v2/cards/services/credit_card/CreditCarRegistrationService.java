package com.api.v2.cards.services.credit_card;

import com.api.v2.cards.dtos.CardRegistrationDto;
import com.api.v2.cards.dtos.CardResponseDto;
import reactor.core.publisher.Mono;

public interface CreditCarRegistrationService {

    Mono<CardResponseDto> register(CardRegistrationDto registrationDto);

}

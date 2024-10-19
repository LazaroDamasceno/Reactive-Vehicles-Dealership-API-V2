package com.api.v1.card.services.debit_card;

import com.api.v1.card.dtos.CardRegistrationDto;
import com.api.v1.card.dtos.CardResponseDto;
import reactor.core.publisher.Mono;

public interface DebitCardRegistrationService {

    Mono<CardResponseDto> register(CardRegistrationDto registrationDto);

}

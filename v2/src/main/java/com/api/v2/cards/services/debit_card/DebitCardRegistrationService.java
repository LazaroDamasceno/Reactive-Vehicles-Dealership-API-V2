package com.api.v2.cards.services.debit_card;

import com.api.v2.cards.dtos.CardRegistrationDto;
import com.api.v2.cards.dtos.CardResponseDto;
import reactor.core.publisher.Mono;

public interface DebitCardRegistrationService {

    Mono<CardResponseDto> register(CardRegistrationDto registrationDto);

}

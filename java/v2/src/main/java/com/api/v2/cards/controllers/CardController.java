package com.api.v2.cards.controllers;

import com.api.v2.cards.dtos.CardRegistrationDto;
import com.api.v2.cards.dtos.CardResponseDto;
import com.api.v2.cards.services.CardRetrievalService;
import com.api.v2.cards.services.credit_card.CreditCarRegistrationService;
import com.api.v2.cards.services.debit_card.DebitCardRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v2/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardRetrievalService cardRetrievalService;
    private final CreditCarRegistrationService creditCardRegistrationService;
    private final DebitCardRegistrationService debitCardRegistrationService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    Flux<CardResponseDto> findAll() {
        return cardRetrievalService.findAll();
    }

    @PostMapping("credit-card")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CardResponseDto> registerCreditCard(@Valid @RequestBody CardRegistrationDto registrationDto) {
        return creditCardRegistrationService.register(registrationDto);
    }

    @PostMapping("debit-card")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CardResponseDto> registerDebitCard(@Valid @RequestBody CardRegistrationDto registrationDto) {
        return debitCardRegistrationService.register(registrationDto);
    }

}

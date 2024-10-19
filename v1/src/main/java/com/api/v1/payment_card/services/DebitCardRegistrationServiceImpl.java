package com.api.v1.payment_card.services;

import com.api.v1.payment_card.domain.Card;
import com.api.v1.payment_card.domain.CardRepository;
import com.api.v1.payment_card.domain.DebitCard;
import com.api.v1.payment_card.dtos.CardRegistrationDto;
import com.api.v1.payment_card.dtos.CardResponseDto;
import com.api.v1.payment_card.exceptions.DuplicatedCardNumberException;
import com.api.v1.payment_card.utils.CardResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class DebitCardRegistrationServiceImpl implements DebitCardRegistrationService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Mono<CardResponseDto> register(@Valid CardRegistrationDto registrationDto) {
        return cardRepository
                .findAll()
                .filter(e -> e.getNumber().equals(registrationDto.cardNumber()))
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return Mono.error(DuplicatedCardNumberException::new);
                    return Mono.defer(() -> {
                        Card card = DebitCard.of(
                                registrationDto.cardNumber(),
                                registrationDto.ownerName(),
                                registrationDto.ownerSsn()
                        );
                        return cardRepository
                                .save(card)
                                .flatMap(CardResponseMapper::mapToMono);
                    });
                });
    }

}

package com.api.v1.card.services.credit_card;

import com.api.v1.card.domain.Card;
import com.api.v1.card.domain.CardRepository;
import com.api.v1.card.domain.CreditCard;
import com.api.v1.card.dtos.CardRegistrationDto;
import com.api.v1.card.dtos.CardResponseDto;
import com.api.v1.card.exceptions.DuplicatedCardNumberException;
import com.api.v1.card.utils.CardResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CreditCarRegistrationServiceImpl implements CreditCarRegistrationService {

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
                        Card card = CreditCard.of(
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

package com.api.v2.cards.services.credit_card;

import com.api.v2.cards.domain.Card;
import com.api.v2.cards.domain.CardRepository;
import com.api.v2.cards.domain.CreditCard;
import com.api.v2.cards.dtos.CardRegistrationDto;
import com.api.v2.cards.dtos.CardResponseDto;
import com.api.v2.cards.exceptions.DuplicatedCardNumberException;
import com.api.v2.cards.utils.CardResponseMapperUtil;
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
                                registrationDto.dueDate(),
                                registrationDto.cvc(),
                                registrationDto.ownerName(),
                                registrationDto.ownerSsn()
                        );
                        return cardRepository
                                .save(card)
                                .flatMap(CardResponseMapperUtil::mapToMono);
                    });
                });
    }

}

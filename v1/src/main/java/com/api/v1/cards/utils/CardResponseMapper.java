package com.api.v1.cards.utils;

import com.api.v1.cards.domain.Card;
import com.api.v1.cards.dtos.CardResponseDto;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

@UtilityClass
public class CardResponseMapper {

    public CardResponseDto mapToDto(Card card) {
        return new CardResponseDto(
                card.getType(),
                card.getNumber(),
                card.getDueDate(),
                card.getCvc(),
                card.getOwnerName(),
                card.getOwnerSsn()
        );
    }

    public Mono<CardResponseDto> mapToMono(Card card) {
        return Mono.just(mapToDto(card));
    }

}

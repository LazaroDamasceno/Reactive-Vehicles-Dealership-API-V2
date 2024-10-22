package com.api.v2.cards.utils;

import com.api.v2.cards.domain.Card;
import com.api.v2.cards.dtos.CardResponseDto;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

@UtilityClass
public class CardResponseMapperUtil {

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

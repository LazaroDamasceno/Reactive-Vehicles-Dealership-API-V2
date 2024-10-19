package com.api.v1.payment_card.utils;

import com.api.v1.payment_card.domain.Card;
import com.api.v1.payment_card.dtos.CardResponseDto;
import com.api.v1.persons.utils.PersonResponseMapperUtil;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardResponseMapper {

    public CardResponseDto mapToDto(Card card) {
        return new CardResponseDto(
                card.getType(),
                card.getNumber(),
                PersonResponseMapperUtil.mapToDto(card.getOwner())
        );
    }

}

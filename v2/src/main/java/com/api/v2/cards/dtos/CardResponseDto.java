package com.api.v2.cards.dtos;

import com.api.v2.cards.utils.CardDueDate;

public record CardResponseDto(
        String type,
        String number,
        CardDueDate dueDate,
        String cvc,
        String ownerName,
        String ownerSsn
) {
}

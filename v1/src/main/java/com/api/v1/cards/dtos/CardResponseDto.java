package com.api.v1.cards.dtos;

import com.api.v1.cards.utils.CardDueDate;

public record CardResponseDto(
        String type,
        String number,
        CardDueDate dueDate,
        String cvc,
        String ownerName,
        String ownerSsn
) {
}

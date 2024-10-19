package com.api.v1.payment_card.dtos;

import com.api.v1.persons.dtos.PersonResponseDto;

public record CardResponseDto(
        String type,
        String number,
        String ownerName,
        String ownerSsn
) {
}

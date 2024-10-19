package com.api.v1.card.dtos;

public record CardResponseDto(
        String type,
        String number,
        String ownerName,
        String ownerSsn
) {
}

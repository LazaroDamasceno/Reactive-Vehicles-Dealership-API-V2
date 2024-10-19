package com.api.v1.payment_card.services;

import com.api.v1.payment_card.domain.CardRepository;
import com.api.v1.payment_card.domain.CreditCard;
import com.api.v1.payment_card.dtos.CardRegistrationDto;
import com.api.v1.payment_card.dtos.CardResponseDto;
import com.api.v1.payment_card.utils.CardResponseMapper;
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
        return cardRepository.save(CreditCard.of(
                        registrationDto.cardNumber(),
                        registrationDto.ownerName(),
                        registrationDto.ownerSsn())
                )
                .flatMap(CardResponseMapper::mapToMono);
    }

}

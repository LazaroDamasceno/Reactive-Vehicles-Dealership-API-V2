package com.api.v1.card.services;

import com.api.v1.card.domain.CardRepository;
import com.api.v1.card.dtos.CardResponseDto;
import com.api.v1.card.utils.CardResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class CardRetrievalServiceImpl implements CardRetrievalService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Flux<CardResponseDto> findAll() {
        return cardRepository
                .findAll()
                .flatMap(card -> Flux.just(CardResponseMapper.mapToDto(card)));
    }

}

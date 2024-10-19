package com.api.v1.cards.services;

import com.api.v1.cards.dtos.CardResponseDto;
import reactor.core.publisher.Flux;

public interface CardRetrievalService {

    Flux<CardResponseDto> findAll();

}

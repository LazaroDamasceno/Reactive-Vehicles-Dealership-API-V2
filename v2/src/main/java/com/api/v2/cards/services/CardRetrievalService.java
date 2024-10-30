package com.api.v2.cards.services;

import com.api.v2.cards.dtos.CardResponseDto;
import reactor.core.publisher.Flux;

public interface CardRetrievalService {

    Flux<CardResponseDto> findAll();

}

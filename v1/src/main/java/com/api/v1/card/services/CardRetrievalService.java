package com.api.v1.card.services;

import com.api.v1.card.dtos.CardResponseDto;
import reactor.core.publisher.Flux;

public interface CardRetrievalService {

    Flux<CardResponseDto> findAll();

}

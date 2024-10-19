package com.api.v1.card.utils;

import com.api.v1.card.annotations.CardNumber;
import com.api.v1.card.domain.Card;
import com.api.v1.card.domain.CardRepository;
import com.api.v1.card.exceptions.CardWasNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CardFinderUtil {

    @Autowired
    private CardRepository cardRepository;

    public Mono<Card> find(@CardNumber String cardNumber) {
        return cardRepository
                .findByNumber(cardNumber)
                .single()
                .switchIfEmpty(Mono.error(CardWasNotFoundException::new));
    }

}

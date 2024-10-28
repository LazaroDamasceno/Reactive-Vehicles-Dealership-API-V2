package com.api.v2.cards.utils;

import com.api.v2.cards.annotations.CardNumber;
import com.api.v2.cards.domain.Card;
import com.api.v2.cards.domain.CardRepository;
import com.api.v2.cards.exceptions.CardWasNotFoundException;
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

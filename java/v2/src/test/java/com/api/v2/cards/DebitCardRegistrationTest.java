package com.api.v2.cards;

import com.api.v2.cards.dtos.CardRegistrationDto;
import com.api.v2.cards.utils.CardDueDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DebitCardRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    CardRegistrationDto registrationDto = new CardRegistrationDto(
            "6543210987654321",
            new CardDueDate(10, 20232),
            "123",
            "Leo",
            "123456789"
    );

    @Test
    void testSuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v2/cards/debit-card")
                .bodyValue(registrationDto)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v2/cards/debit-card")
                .bodyValue(registrationDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}

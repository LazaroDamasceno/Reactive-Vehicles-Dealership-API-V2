package com.api.v2.purchases;

import com.api.v2.purchase.dtos.PurchaseRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PurchaseRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    PurchaseRegistrationRequestDto requestDto = new PurchaseRegistrationRequestDto(
            "123456789",
            "",
            "",
            ""
    );

    @Test
    void testSuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v2/purchases")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v2/purchases")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

package com.api.v2.customers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerDeletionTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testSuccessfulDeletion() {
        webTestClient
                .patch()
                .uri("api/v2/customers/123456789")
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulDeletion() {
        webTestClient
                .patch()
                .uri("api/v2/customers/123456789")
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

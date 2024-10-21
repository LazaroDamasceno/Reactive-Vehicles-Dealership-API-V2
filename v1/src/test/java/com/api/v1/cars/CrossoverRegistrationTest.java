package com.api.v1.cars;

import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrossoverRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testSuccessful() {
        var requestDto = new VehicleRegistrationRequestDto(
                "Acadia",
                "GMC",
                120_000,
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/cars/crossover")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

}

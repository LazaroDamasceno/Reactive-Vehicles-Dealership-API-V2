package com.api.v2.cars;

import com.api.v2.vehicles.dtos.VehicleRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SedanRegistrationTest {

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
                .uri("api/v2/cars/sedan")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

}

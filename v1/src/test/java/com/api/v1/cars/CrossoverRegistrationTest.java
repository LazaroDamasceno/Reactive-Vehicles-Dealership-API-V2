package com.api.v1.cars;

import com.api.v1.cars.dtos.CarResponseDto;
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
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/crossovers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(CarResponseDto.class);
    }

    @Test
    void testUnsuccessful1() {
        var requestDto = new VehicleRegistrationRequestDto(
                null,
                "GMC",
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/crossovers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    void testUnsuccessful2() {
        var requestDto = new VehicleRegistrationRequestDto(
                "Acadia",
                null,
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/crossovers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    void testUnsuccessful3() {
        var requestDto = new VehicleRegistrationRequestDto(
                null,
                null,
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/crossovers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }


}

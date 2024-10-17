package com.api.v1.cars;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SedanRegistrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulRegistration() {
        var requestDto = new VehicleRegistrationRequestDto(
                "Malibu",
                "Chevrolet",
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/sedans")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(CarResponseDto.class);
    }

    @Test
    void testUnsuccessfulRegistration1() {
        var requestDto = new VehicleRegistrationRequestDto(
                null,
                "Chevrolet",
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/sedans")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    void testUnsuccessfulRegistration2() {
        var requestDto = new VehicleRegistrationRequestDto(
                "Malibu",
                null,
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/sedans")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    void testUnsuccessfulRegistration3() {
        var requestDto = new VehicleRegistrationRequestDto(
                null,
                null,
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/sedans")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }

}

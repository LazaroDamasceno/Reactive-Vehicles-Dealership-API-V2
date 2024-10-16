package com.api.v1;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SuvRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testSuccessfulRegistration() {
        var requestDto = new VehicleRegistrationRequestDto(
                "Lyriq",
                "Cadillac",
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/suv")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(CarResponseDto.class);
    }

    @Test
    void testUnsuccessfulRegistration1() {
        var requestDto = new VehicleRegistrationRequestDto(
                null,
                "Cadillac",
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/suv")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    void testUnsuccessfulRegistration2() {
        var requestDto = new VehicleRegistrationRequestDto(
                "Lyriq",
                null,
                2024
        );
        webTestClient
                .post()
                .uri("api/v1/suv")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }

}

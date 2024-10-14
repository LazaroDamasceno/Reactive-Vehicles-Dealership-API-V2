package com.api.v1;

import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerRegistrationTest {

    @Autowired
    private WebTestClient webTestClient;

    PersonRegistrationRequestDto requestDto = new PersonRegistrationRequestDto(
            "Leo",
            "",
            "Santos",
            "123456789",
            LocalDate.parse("2000-12-12"),
            "leosantos@mail.com",
            "St. Dennis, Paris",
            "1234567890",
            "male"
    );

    @Test
    void testSuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v1/customers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(CustomerResponseDto.class);
    }

    @Test
    void testUnsuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v1/customers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

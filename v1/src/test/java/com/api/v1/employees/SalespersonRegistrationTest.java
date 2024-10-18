package com.api.v1.employees;

import com.api.v1.persons.dtos.PersonRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalespersonRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    PersonRegistrationRequestDto requestDto = new PersonRegistrationRequestDto(
            "Gabriel",
            "",
            "Valença",
            "987654321",
            LocalDate.parse("2000-12-12"),
            "g.valenca@mail.com",
            "St. Dennis, Paris",
            "1234567890",
            "male"
    );

    @Test
    void testSuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v1/employees/salesperson")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulRegistration() {
        webTestClient
                .post()
                .uri("api/v1/employees/salesperson")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

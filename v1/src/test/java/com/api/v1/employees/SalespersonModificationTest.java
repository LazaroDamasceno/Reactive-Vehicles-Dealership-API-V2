package com.api.v1.employees;

import com.api.v1.persons.dtos.PersonModificationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalespersonModificationTest {

    @Autowired
    WebTestClient webTestClient;

    PersonModificationRequestDto requestDto = new PersonModificationRequestDto(
            "Gabriel",
            "Silva",
            "Valença Jr.",
            LocalDate.parse("2000-12-12"),
            "jr@gabrielvalenca.com",
            "St. Dennis, Paris, UE",
            "0987654321",
            "cis male"
    );

    @Test
    void testSuccessModification() {
        webTestClient
                .put()
                .uri("api/v1/employees/5583383")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulModification() {
        webTestClient
                .put()
                .uri("api/v1/employees/5583382")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

package com.api.v1.customers;

import com.api.v1.customers.dtos.CustomerResponseDto;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerModificationTest {

    @Autowired
    WebTestClient webTestClient;

    PersonModificationRequestDto requestDto = new PersonModificationRequestDto(
            "Leo",
            "Silva",
            "Santos Jr.",
            LocalDate.parse("2000-12-12"),
            "jr@leosantos.com",
            "St. Dennis, Paris, France",
            "0987654321",
            "cis male"
    );

    @Test
    void testSuccessfulModification() {
        webTestClient
                .put()
                .uri("api/v1/customers/123456789")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(CustomerResponseDto.class);
    }

    @Test
    void testUnsuccessfulModification() {
        webTestClient
                .put()
                .uri("api/v1/customers/123456788")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

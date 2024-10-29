package com.api.v3

import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class CustomerRegistrationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    val requestDto = PersonRegistrationRequestDto(
        "Leo",
        "",
        "Santos",
        "123456789",
        "leosantos@gmail.com",
        LocalDate.parse("2000-12-12"),
        "St. Dennis",
        "male",
        "1234567890"
    )

    @Test
    fun testSuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v3/customers")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulRegistration() {
        webTestClient
            .post()
            .uri("api/v3/customers")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is5xxServerError()
    }

}
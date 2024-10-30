package com.api.v3

import com.api.v3.persons.dtos.PersonModificationRequestDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class CustomerModificationTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    val requestDto = PersonModificationRequestDto(
        "Leo",
        "Silva",
        "Santos Jr.",
        "jr@leosanros.com",
        LocalDate.parse("2000-12-12"),
        "St. Dennis, Paris",
        "cis male",
        "0987654321"
    )

    @Test
    fun testSuccessfulRegistration() {
        webTestClient
            .put()
            .uri("api/v3/customers/123456789")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulRegistration() {
        webTestClient
            .put()
            .uri("api/v3/customers/123456788")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus().is5xxServerError()
    }

}
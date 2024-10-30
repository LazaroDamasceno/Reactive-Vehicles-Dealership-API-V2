package com.api.v2.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeTerminationTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testSuccessfulTermination() {
        var employeeId = "";
        webTestClient
                .patch()
                .uri("api/v2/employees/%s".formatted(employeeId))
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulTermination() {
        var employeeId = "";
        webTestClient
                .patch()
                .uri("api/v2/employees/%s".formatted(employeeId))
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

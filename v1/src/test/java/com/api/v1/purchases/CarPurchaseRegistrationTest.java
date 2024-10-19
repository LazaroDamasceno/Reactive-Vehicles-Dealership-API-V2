package com.api.v1.purchases;

import com.api.v1.purchases.dtos.PurchaseRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarPurchaseRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testSuccessfulRegistration() {
        var ssn = "123456789";
        var employeeId = "1861723";
        var vin = "4556705949225454611";
        var requestDto = new PurchaseRegistrationRequestDto(ssn, employeeId, vin);
        webTestClient
                .post()
                .uri("api/v1/purchases/car")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulRegistration1() {
        var ssn = "123456789";
        var employeeId = "1861723";
        var vin = "4556705949225454611";
        var requestDto = new PurchaseRegistrationRequestDto(ssn, employeeId, vin);
        webTestClient
                .post()
                .uri("api/v1/purchases/car")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void testUnsuccessfulRegistration2() {
        var ssn = "123456788";
        var employeeId = "1861723";
        var vin = "4556705949225454611";
        var requestDto = new PurchaseRegistrationRequestDto(ssn, employeeId, vin);
        webTestClient
                .post()
                .uri("api/v1/purchases/car")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void testUnsuccessfulRegistration3() {
        var ssn = "123456789";
        var employeeId = "1861722";
        var vin = "4556705949225454611";
        var requestDto = new PurchaseRegistrationRequestDto(ssn, employeeId, vin);
        webTestClient
                .post()
                .uri("api/v1/purchases/car")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void testUnsuccessfulRegistration4() {
        var ssn = "123456789";
        var employeeId = "1861723";
        var vin = "4556705949225454610";
        var requestDto = new PurchaseRegistrationRequestDto(ssn, employeeId, vin);
        webTestClient
                .post()
                .uri("api/v1/purchases/car")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus().is5xxServerError();
    }

}

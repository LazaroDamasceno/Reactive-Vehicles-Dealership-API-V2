package com.api.v1;

import com.api.v1.person.domain.Person;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import com.api.v1.person.services.PersonRegistrationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonRegistrationTest {

	@Autowired
	private PersonRegistrationService personRegistrationService;

	@Test
	void testSuccessfulRegistration() {
		var requestDto = new PersonRegistrationRequestDto(
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
		Mono<Person> response = personRegistrationService.register(requestDto);
		response.subscribe(Assertions::assertNotNull);
	}

	@Test
	void testUnsuccessfulRegistration1() {
		var requestDto = new PersonRegistrationRequestDto(
				"Leo",
				"",
				"Santos",
				"1234567890",
				LocalDate.parse("2000-12-12"),
				"leosantos@mail.com",
				"St. Dennis, Paris",
				"1234567890",
				"male"
		);
		Mono<Person> response = personRegistrationService.register(requestDto);
		response.subscribe(Assertions::assertNull);
	}

	@Test
	void testUnsuccessfulRegistration2() {
		var requestDto = new PersonRegistrationRequestDto(
				"Leo",
				"",
				"Santos",
				"123456789",
				LocalDate.parse("2000-12-12"),
				"leosantosmail.com",
				"St. Dennis, Paris",
				"1234567890",
				"male"
		);
		Mono<Person> response = personRegistrationService.register(requestDto);
		response.subscribe(Assertions::assertNull);
	}

	@Test
	void testUnsuccessfulRegistration3() {
		var requestDto = new PersonRegistrationRequestDto(
				"Leo",
				"",
				"Santos",
				"123456789",
				LocalDate.parse("2000-12-12"),
				"leosantos@mail.com",
				"St. Dennis, Paris",
				"123456789",
				"male"
		);
		Mono<Person> response = personRegistrationService.register(requestDto);
		response.subscribe(Assertions::assertNull);
	}

}

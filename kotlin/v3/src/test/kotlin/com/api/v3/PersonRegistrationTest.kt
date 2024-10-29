package com.api.v3

import com.api.v3.persons.domain.Person
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import com.api.v3.persons.services.PersonRegistrationService
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class PersonRegistrationTest {

    @Autowired
    private lateinit var personRegistrationService: PersonRegistrationService

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
        runBlocking {
            val expectedResponse = Person::class
            val actualResponse = personRegistrationService.register(requestDto)::class
            assertEquals(expectedResponse, actualResponse)
        }
    }

}
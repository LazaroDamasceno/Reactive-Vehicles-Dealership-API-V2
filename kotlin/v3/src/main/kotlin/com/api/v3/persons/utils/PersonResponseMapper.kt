package com.api.v3.persons.utils

import com.api.v3.persons.domain.Person
import com.api.v3.persons.dtos.PersonResponseDto
import java.time.ZonedDateTime

class PersonResponseMapper {

    companion object {
        fun map(person: Person): PersonResponseDto {
            return PersonResponseDto(
                person.fullName(),
                person.ssn,
                person.birthDate,
                person.email,
                person.address,
                person.gender,
                person.phoneNumber,
                ZonedDateTime.of(person.createdAt, person.createdAtZone)
            )
        }
    }

}
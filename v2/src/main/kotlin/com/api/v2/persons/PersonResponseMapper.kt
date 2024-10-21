package com.api.v2.persons

import com.api.v2.persons.domain.Person
import com.api.v2.persons.dtos.PersonResponseDto

class PersonResponseMapper {

    companion object {
        fun map(person: Person): PersonResponseDto {
            return PersonResponseDto(
                person.fullName(),
                person.birthDate,
                person.ssn,
                person.email,
                person.address,
                person.gender,
                person.phoneNumber
            )
        }
    }

}
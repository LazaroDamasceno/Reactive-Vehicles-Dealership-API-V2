package com.api.v2.persons.utils;

import com.api.v2.persons.dtos.PersonResponseDto;
import com.api.v2.persons.domain.Person;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class PersonResponseMapperUtil {

    public PersonResponseDto mapToDto(Person person) {
        return new PersonResponseDto(
                PersonFullNameFormatterUtil.formatFullName(person),
                person.getSsn(),
                person.getBirthDate(),
                person.getEmail(),
                person.getAddress(),
                person.getPhoneNumber(),
                person.getGender(),
                ZonedDateTime.of(person.getCreatedAt(), person.getCreatedAtZone())
        );
    }

}

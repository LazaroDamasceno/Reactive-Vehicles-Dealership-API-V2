package com.api.v1.persons.utils;

import com.api.v1.persons.dtos.PersonResponseDto;
import com.api.v1.persons.domain.PersonEntity;
import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;

@UtilityClass
public class PersonResponseMapperUtil {

    public PersonResponseDto mapToDto(PersonEntity personEntity) {
        return new PersonResponseDto(
                PersonFullNameFormatterUtil.formatFullName(personEntity),
                personEntity.getSsn(),
                personEntity.getBirthDate(),
                personEntity.getEmail(),
                personEntity.getAddress(),
                personEntity.getPhoneNumber(),
                personEntity.getGender(),
                ZonedDateTime.of(personEntity.getCreatedAt(), personEntity.getCreatedAtZone())
        );
    }

}

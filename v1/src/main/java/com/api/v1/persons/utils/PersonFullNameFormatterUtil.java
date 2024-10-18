package com.api.v1.persons.utils;

import com.api.v1.persons.domain.PersonEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonFullNameFormatterUtil {

    public String formatFullName(PersonEntity personEntity) {
        if (personEntity.getMiddleName() == null || personEntity.getMiddleName().isEmpty()) {
            return "%s %s".formatted(personEntity.getFirstName(), personEntity.getLastName());
        }
        return "%s %s %s".formatted(personEntity.getFirstName(), personEntity.getMiddleName(), personEntity.getLastName());
    }

}

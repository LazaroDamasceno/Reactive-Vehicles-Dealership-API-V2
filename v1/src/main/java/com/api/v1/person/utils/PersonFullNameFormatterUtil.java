package com.api.v1.person.utils;

import com.api.v1.person.domain.Person;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonFullNameFormatterUtil {

    public String formatFullName(Person person) {
        if (person.getMiddleName() == null || person.getMiddleName().isEmpty()) {
            return "%s %s".formatted(person.getFirstName(), person.getLastName());
        }
        return "%s %s %s".formatted(person.getFirstName(), person.getMiddleName(), person.getLastName());
    }

}

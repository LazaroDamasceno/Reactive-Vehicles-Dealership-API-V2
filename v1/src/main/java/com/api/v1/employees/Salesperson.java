package com.api.v1.employees;

import com.api.v1.persons.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Getter
public class Salesperson extends Employee {

    private Salesperson(Person person) {
        super("Salesperson", person);
    }

    public static Salesperson of(Person person) {
        return new Salesperson(person);
    }

}

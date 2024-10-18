package com.api.v1.persons.services;

import com.api.v1.persons.domain.Person;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface PersonModificationService {

    Mono<Person> modify(Person person, PersonModificationRequestDto requestDto);

}

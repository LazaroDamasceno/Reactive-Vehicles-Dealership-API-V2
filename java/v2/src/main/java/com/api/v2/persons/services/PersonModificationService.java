package com.api.v2.persons.services;

import com.api.v2.persons.domain.Person;
import com.api.v2.persons.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface PersonModificationService {

    Mono<Person> modify(Person person, PersonModificationRequestDto requestDto);

}

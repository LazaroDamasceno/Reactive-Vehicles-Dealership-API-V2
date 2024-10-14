package com.api.v1.person.services;

import com.api.v1.person.domain.Person;
import com.api.v1.person.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface PersonModificationService {

    Mono<Person> modify(Person person, PersonModificationRequestDto requestDto);

}

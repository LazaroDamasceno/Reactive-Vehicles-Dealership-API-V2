package com.api.v2.persons.services;

import com.api.v2.persons.domain.Person;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface PersonRegistrationService {

    Mono<Person> register(PersonRegistrationRequestDto requestDto);

}

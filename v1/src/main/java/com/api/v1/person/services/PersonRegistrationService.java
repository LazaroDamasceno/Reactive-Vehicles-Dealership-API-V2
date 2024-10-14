package com.api.v1.person.services;

import com.api.v1.person.domain.Person;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface PersonRegistrationService {

    Mono<Person> register(PersonRegistrationRequestDto requestDto);

}

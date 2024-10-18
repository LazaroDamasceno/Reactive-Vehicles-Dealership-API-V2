package com.api.v1.persons.services;

import com.api.v1.persons.domain.PersonEntity;
import com.api.v1.persons.dtos.PersonRegistrationRequestDto;
import reactor.core.publisher.Mono;

public interface PersonRegistrationService {

    Mono<PersonEntity> register(PersonRegistrationRequestDto requestDto);

}

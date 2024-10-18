package com.api.v1.persons.services;

import com.api.v1.persons.domain.PersonEntity;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import reactor.core.publisher.Mono;

public interface PersonModificationService {

    Mono<PersonEntity> modify(PersonEntity personEntity, PersonModificationRequestDto requestDto);

}

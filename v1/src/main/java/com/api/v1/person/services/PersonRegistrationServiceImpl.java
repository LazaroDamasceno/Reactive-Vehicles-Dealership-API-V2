package com.api.v1.person.services;

import com.api.v1.person.domain.Person;
import com.api.v1.person.domain.PersonRepository;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class PersonRegistrationServiceImpl implements PersonRegistrationService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Mono<Person> register(@Valid PersonRegistrationRequestDto requestDto) {
        return personRepository.save(Person.of(requestDto));
    }

}

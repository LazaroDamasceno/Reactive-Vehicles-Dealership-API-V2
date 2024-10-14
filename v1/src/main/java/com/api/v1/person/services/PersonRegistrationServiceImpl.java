package com.api.v1.person.services;

import com.api.v1.person.domain.Person;
import com.api.v1.person.domain.PersonRepository;
import com.api.v1.person.dtos.PersonRegistrationRequestDto;
import com.api.v1.person.exceptions.DuplicatedEmailException;
import com.api.v1.person.exceptions.DuplicatedSsnException;
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
        return personRepository
                .findBySsn(requestDto.ssn())
                .hasElement()
                .flatMap(ssnExists -> {
                    if (ssnExists) return Mono.error(DuplicatedSsnException::new);
                    return personRepository
                            .findByEmail(requestDto.email())
                            .hasElement()
                            .flatMap(emailExists -> {
                                if (emailExists) return Mono.error(DuplicatedEmailException::new);
                                return personRepository.save(Person.of(requestDto));
                            });
                });
    }

}

package com.api.v1.persons.services;

import com.api.v1.persons.domain.Person;
import com.api.v1.persons.domain.PersonAuditTrail;
import com.api.v1.persons.domain.PersonAuditTrailRepository;
import com.api.v1.persons.domain.PersonRepository;
import com.api.v1.persons.dtos.PersonModificationRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class PersonModificationServiceImpl implements PersonModificationService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonAuditTrailRepository auditTrailRepository;

    @Override
    public Mono<Person> modify(@NotNull Person person, @Valid PersonModificationRequestDto requestDto) {
        return auditTrailRepository
                .save(PersonAuditTrail.of(person))
                .then(Mono.defer(() -> {
                    person.modify(requestDto);
                    return personRepository.save(person);
                }));
    }

}

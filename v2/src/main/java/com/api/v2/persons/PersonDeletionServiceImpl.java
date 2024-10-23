package com.api.v2.persons;

import com.api.v2.persons.domain.Person;
import com.api.v2.persons.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class PersonDeletionServiceImpl implements PersonDeletionService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Mono<Void> bookDeletion(Person person) {
        return personRepository.delete(person);
    }

}

package com.api.v2.persons;

import com.api.v2.persons.domain.Person;
import reactor.core.publisher.Mono;

public interface PersonDeletionService {

    Mono<Void> bookDeletion(Person person);

}

package com.api.v2.persons.services

import com.api.v2.persons.domain.Person
import com.api.v2.persons.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class PersonBookDeletionServiceImpl: PersonBookDeletionService {

    @Autowired
    lateinit var personRepository: PersonRepository

    override suspend fun bookDeletion(person: Person): Person {
        return withContext(Dispatchers.IO) {
            person.bookedDeletionDate()
            personRepository.save(person)
        }
    }

}
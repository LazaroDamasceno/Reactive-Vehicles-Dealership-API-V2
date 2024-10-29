package com.api.v3.persons.utils

import com.api.v3.persons.domain.Person
import com.api.v3.persons.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonFinderUtil {

    @Autowired
    private lateinit var personRepository: PersonRepository

    suspend fun find(ssn: String): Person? {
        return withContext(Dispatchers.IO) {
            personRepository
                .findAll()
                .filter { e -> e.ssn == ssn }
                .singleOrNull()
        }
    }

}
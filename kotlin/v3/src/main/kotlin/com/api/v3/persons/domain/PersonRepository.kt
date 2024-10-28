package com.api.v3.persons.domain

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PersonRepository: CoroutineCrudRepository<Person, UUID> {

    @Query("{ 'ssn': ?0 }")
    fun findBySsn(ssn: String): Person?

    @Query("{ 'email': ?0 }")
    fun findByEmail(email: String): Person?

}
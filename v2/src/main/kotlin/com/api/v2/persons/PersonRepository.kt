package com.api.v2.persons

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PersonRepository: CoroutineCrudRepository<Person, UUID> {

    @Query("{ 'ssn': ?0 }")
    fun findBySsn(ssn: String): Person?

}
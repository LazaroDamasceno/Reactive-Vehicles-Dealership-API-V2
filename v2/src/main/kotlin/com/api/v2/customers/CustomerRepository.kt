package com.api.v2.customers

import com.api.v2.persons.domain.Person
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CustomerRepository: CoroutineCrudRepository<Customer,UUID> {

    @Query("{ 'person': ?0 }")
    fun findByPerson(person: Person): Customer

}
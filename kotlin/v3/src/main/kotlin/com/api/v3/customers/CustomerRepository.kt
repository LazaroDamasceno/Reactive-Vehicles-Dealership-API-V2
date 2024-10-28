package com.api.v3.customers

import com.api.v3.persons.domain.Person
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CustomerRepository: CoroutineCrudRepository<Customer, UUID> {

    @Query("{ 'person': ?0 }")
    fun findByPerson(person: Person): Person

}
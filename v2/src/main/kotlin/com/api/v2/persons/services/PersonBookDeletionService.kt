package com.api.v2.persons.services

import com.api.v2.persons.domain.Person

interface PersonBookDeletionService {

    suspend fun bookDeletion(person: Person): Person

}
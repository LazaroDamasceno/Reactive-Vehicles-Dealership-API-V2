package com.api.v3.persons.services

import com.api.v3.persons.domain.Person
import com.api.v3.persons.dtos.PersonModificationRequestDto

interface PersonModificationService {

    suspend fun modify(person: Person, requestDto: PersonModificationRequestDto): Person

}
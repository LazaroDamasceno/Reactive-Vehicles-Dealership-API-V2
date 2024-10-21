package com.api.v2.persons.services

import com.api.v2.persons.domain.Person
import com.api.v2.persons.dtos.PersonModificationDto

interface PersonModificationService {

    suspend fun modify(person: Person, requestModificationDto: PersonModificationDto): Person

}
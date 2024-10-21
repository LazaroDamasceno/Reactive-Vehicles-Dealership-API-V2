package com.api.v2.persons

interface PersonModificationService {

    suspend fun modify(person: Person, requestModificationDto: PersonModificationDto): Person

}
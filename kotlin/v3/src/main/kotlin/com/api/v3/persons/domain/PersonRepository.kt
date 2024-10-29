package com.api.v3.persons.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PersonRepository: CoroutineCrudRepository<Person, UUID>
package com.api.v3.customers.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CustomerRepository: CoroutineCrudRepository<Customer, UUID>
package com.api.v3.customers.utils

import com.api.v3.customers.domain.Customer
import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.exceptions.CustomerNotFoundException
import com.api.v3.persons.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component

@Component
class CustomerFinderUtil(
    private val personRepository: PersonRepository,
    private val customerRepository: CustomerRepository
) {

    suspend fun find(ssn: String): Customer {
        return withContext(Dispatchers.IO) {
            val existingPerson = personRepository.findBySsn(ssn)
            if (existingPerson == null) {
                throw CustomerNotFoundException()
            }
            customerRepository.findByPerson(existingPerson)
        }
    }

}
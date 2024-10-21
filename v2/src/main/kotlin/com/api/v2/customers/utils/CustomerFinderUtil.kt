package com.api.v2.customers.utils

import com.api.v2.customers.domain.Customer
import com.api.v2.customers.domain.CustomerRepository
import com.api.v2.customers.exceptions.CustomerNotFoundException
import com.api.v2.persons.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerFinderUtil {

    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    suspend fun find(ssn: String): Customer {
        return withContext(Dispatchers.IO) {
            val nullablePerson = personRepository.findBySsn(ssn)
            if (nullablePerson == null) {
                throw CustomerNotFoundException()
            }
            customerRepository.findByPerson(nullablePerson)
        }
    }

}
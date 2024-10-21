package com.api.v2.customers

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

    suspend fun find(ssn: String) {
        return withContext(Dispatchers.IO) {
            val nullablePerson = personRepository.findBySsn(ssn)
            if (nullablePerson == null) {
                throw CustomerNotFoundException()
            }
            customerRepository.findByPerson(nullablePerson)
        }
    }

}
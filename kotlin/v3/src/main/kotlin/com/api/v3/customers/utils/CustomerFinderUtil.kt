package com.api.v3.customers.utils

import com.api.v3.customers.domain.Customer
import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.exceptions.CustomerNotFoundException
import com.api.v3.persons.utils.PersonFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerFinderUtil {

    @Autowired
    private lateinit var personFinderUtil: PersonFinderUtil

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    suspend fun find(ssn: String): Customer {
        return withContext(Dispatchers.IO) {
            val existingPerson = personFinderUtil.find(ssn)
            if (existingPerson == null) {
                throw CustomerNotFoundException()
            }
            customerRepository
                .findAll()
                .filter { e -> e.person == existingPerson }
                .single()
        }
    }

}
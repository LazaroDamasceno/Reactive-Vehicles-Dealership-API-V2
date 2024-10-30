package com.api.v3.customers.utils

import com.api.v3.customers.domain.Customer
import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.exceptions.CustomerNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerFinderUtil {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    suspend fun find(ssn: String): Customer {
        return withContext(Dispatchers.IO) {
            val existingCustomer = customerRepository
                .findAll()
                .filter { e -> e.person.ssn == ssn }
                .singleOrNull()
            if (existingCustomer == null) throw CustomerNotFoundException()
            existingCustomer
        }
    }

}
package com.api.v2.customers.services

import com.api.v2.customers.domain.CustomerRepository
import com.api.v2.customers.exceptions.UnchangeableCustomerException
import com.api.v2.customers.utils.CustomerFinderUtil
import com.api.v2.persons.services.PersonBookDeletionService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerBookDeletionImpl: CustomerBookDeletion {

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var personBookDeletionService: PersonBookDeletionService

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun bookDeletion(ssn: String) {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            if (customer.bookedDeletionDate != null) {
                throw UnchangeableCustomerException()
            }
            val personBookedDeletion = personBookDeletionService.bookDeletion(customer.person)
            customer.setBookedDeletionDate(personBookedDeletion)
            customerRepository.save(customer)
        }
    }

}
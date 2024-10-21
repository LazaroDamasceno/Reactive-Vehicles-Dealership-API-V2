package com.api.v2.customers.services

import com.api.v2.customers.domain.Customer
import com.api.v2.customers.domain.CustomerRepository
import com.api.v2.persons.dtos.PersonRegistrationDto
import com.api.v2.persons.services.PersonRegistrationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerRegistrationServiceImpl: CustomerRegistrationService {

    @Autowired
    lateinit var personRegistrationService: PersonRegistrationService

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun register(personRegistrationDto: PersonRegistrationDto) {
        return withContext(Dispatchers.IO) {
            val savedPerson = personRegistrationService.register(personRegistrationDto)
            val customer = Customer.of(savedPerson)
            customerRepository.save(customer)
        }
    }

}
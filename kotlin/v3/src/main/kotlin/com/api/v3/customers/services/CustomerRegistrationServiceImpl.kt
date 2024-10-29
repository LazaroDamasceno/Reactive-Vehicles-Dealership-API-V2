package com.api.v3.customers.services

import com.api.v3.customers.domain.Customer
import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.utils.CustomerResponseMapper
import com.api.v3.persons.dtos.PersonRegistrationRequestDto
import com.api.v3.persons.services.PersonRegistrationService
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CustomerRegistrationServiceImpl: CustomerRegistrationService {

    @Autowired
    private lateinit var personRegistrationService: PersonRegistrationService

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    override suspend fun register(requestDto: @Valid PersonRegistrationRequestDto) {
        return withContext(Dispatchers.IO) {
            val savedPerson = personRegistrationService.register(requestDto)
            val customer = Customer.of(savedPerson)
            val savedCustomer = customerRepository.save(customer)
            CustomerResponseMapper.map(savedCustomer)
        }
    }

}
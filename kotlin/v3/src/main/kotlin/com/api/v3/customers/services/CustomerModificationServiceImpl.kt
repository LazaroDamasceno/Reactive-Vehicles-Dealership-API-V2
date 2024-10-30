package com.api.v3.customers.services

import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.utils.CustomerFinderUtil
import com.api.v3.customers.utils.CustomerResponseMapper
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.services.PersonModificationService
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
internal class CustomerModificationServiceImpl: CustomerModificationService {

    @Autowired
    private lateinit var customerFinder: CustomerFinderUtil

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var personModificationService: PersonModificationService

    override suspend fun modify(ssn: String, requestDto: @Valid PersonModificationRequestDto): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val existingCustomer = customerFinder.find(ssn)
            val modifiedPerson = personModificationService.modify(existingCustomer.person, requestDto)
            existingCustomer.person = modifiedPerson
            val modifiedCustomer = customerRepository.save(existingCustomer)
            CustomerResponseMapper.map(modifiedCustomer)
        }
    }

}
package com.api.v3.customers.services

import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.utils.CustomerFinderUtil
import com.api.v3.customers.utils.CustomerResponseMapper
import com.api.v3.persons.domain.PersonRepository
import com.api.v3.persons.dtos.PersonModificationRequestDto
import com.api.v3.persons.services.PersonModificationService
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
internal class CustomerModificationServiceImpl(
    private val customerFinderUtil: CustomerFinderUtil,
    private val personModificationService: PersonModificationService,
    private val customerRepository: CustomerRepository
): CustomerModificationService {

    override suspend fun modify(ssn: String, requestDto: @Valid PersonModificationRequestDto): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val existingCustomer = customerFinderUtil.find(ssn)
            val existingPerson = existingCustomer.person
            val modifiedPerson = personModificationService.modify(existingPerson, requestDto)
            existingCustomer.person = modifiedPerson
            val modifiedCustomer = customerRepository.save(existingCustomer)
            CustomerResponseMapper.map(modifiedCustomer)
        }
    }

}

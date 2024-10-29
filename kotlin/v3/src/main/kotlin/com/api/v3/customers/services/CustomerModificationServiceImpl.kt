package com.api.v3.customers.services

import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.utils.CustomerFinderUtil
import com.api.v3.persons.domain.PersonAuditTrail
import com.api.v3.persons.domain.PersonAuditTrailRepository
import com.api.v3.persons.domain.PersonRepository
import com.api.v3.persons.dtos.PersonModificationRequestDto
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
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var personAuditTrailRepository: PersonAuditTrailRepository

    override suspend fun modify(ssn: String, requestDto: @Valid PersonModificationRequestDto) {
        return withContext(Dispatchers.IO) {
            val existingCustomer = customerFinder.find(ssn)
            val existingPerson = existingCustomer.person

            val auditTrail = PersonAuditTrail.of(existingPerson)
            var savedAuditTrail = personAuditTrailRepository.save(auditTrail)

            existingPerson.modify(requestDto)
            val savedPerson = personRepository.save(existingPerson)
            existingCustomer.person = savedPerson
            customerRepository.save(existingCustomer)
        }
    }

}
package com.api.v3.customers.services

import com.api.v3.customers.domain.CustomerRepository
import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.customers.utils.CustomerFinderUtil
import com.api.v3.customers.utils.CustomerResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
internal class CustomerRetrievalServiceImpl(
    private val customerFinderUtil: CustomerFinderUtil,
    private val customerRepository: CustomerRepository
): CustomerRetrievalService {

    override suspend fun findBySsn(ssn: String): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val existingCustomer = customerFinderUtil.find(ssn)
            CustomerResponseMapper.map(existingCustomer)
        }
    }

    override suspend fun findAll(): Flow<CustomerResponseDto> {
        return withContext(Dispatchers.IO) {
            customerRepository
                .findAll()
                .map { e -> CustomerResponseMapper.map(e) }
        }
    }

}
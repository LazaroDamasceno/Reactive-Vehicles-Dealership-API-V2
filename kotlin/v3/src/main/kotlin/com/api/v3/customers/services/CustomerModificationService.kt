package com.api.v3.customers.services

import com.api.v3.customers.dtos.CustomerResponseDto
import com.api.v3.persons.dtos.PersonModificationRequestDto

interface CustomerModificationService {

    suspend fun modify(ssn: String, requestDto: PersonModificationRequestDto): CustomerResponseDto

}
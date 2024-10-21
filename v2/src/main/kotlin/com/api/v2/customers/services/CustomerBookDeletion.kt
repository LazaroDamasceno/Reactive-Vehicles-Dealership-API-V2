package com.api.v2.customers.services

interface CustomerBookDeletion {

    suspend fun bookDeletion(ssn: String)

}
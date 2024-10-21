package com.api.v2.customers

interface CustomerBookDeletion {

    suspend fun bookDeletion(ssn: String)

}
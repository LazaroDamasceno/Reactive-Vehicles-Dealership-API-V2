package com.api.v2.customers

import com.api.v2.customers.services.CustomerBookDeletion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/customers")
class CustomerController {

    @Autowired
    lateinit var customerBookDeletion: CustomerBookDeletion

    @PatchMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun bookDeletion(@PathVariable ssn: String) {
        return customerBookDeletion.bookDeletion(ssn)
    }

}
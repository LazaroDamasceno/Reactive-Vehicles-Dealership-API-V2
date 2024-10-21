package com.api.v2.customers.exceptions

class UnchangeableCustomerException: RuntimeException("Customer is booked to be deleted.") {
}
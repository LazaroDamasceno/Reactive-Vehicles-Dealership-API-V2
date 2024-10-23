package com.api.v2.customers.exceptions;

import java.time.LocalDateTime;

public class UnchangeableCustomerException extends RuntimeException {
    public UnchangeableCustomerException(LocalDateTime deletionDate) {
        super("Customer is set to deleted on %s".formatted(deletionDate));
    }
}

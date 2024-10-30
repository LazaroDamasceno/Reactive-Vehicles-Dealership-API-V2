package com.api.v2.employees.exception;

public class TerminatedEmployeeException extends RuntimeException {
    public TerminatedEmployeeException() {
        super("Employee is terminated.");
    }
}

package com.api.v2.persons.exceptions;

public class DuplicatedSsnException extends RuntimeException {
    public DuplicatedSsnException() {
        super("The given SSN is already registered.");
    }
}

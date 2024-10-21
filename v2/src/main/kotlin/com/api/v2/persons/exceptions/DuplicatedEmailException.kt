package com.api.v2.persons.exceptions

class DuplicatedEmailException: RuntimeException("The given email is already registered.")
package com.api.v3.persons.exceptions

import java.lang.RuntimeException

class DuplicatedSsnException: RuntimeException("The given SSN is already registered.")
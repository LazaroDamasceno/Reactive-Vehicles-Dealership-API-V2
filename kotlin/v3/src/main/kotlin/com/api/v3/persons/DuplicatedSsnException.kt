package com.api.v3.persons

import java.lang.RuntimeException

class DuplicatedSsnException: RuntimeException("The given SSN is already registered.")
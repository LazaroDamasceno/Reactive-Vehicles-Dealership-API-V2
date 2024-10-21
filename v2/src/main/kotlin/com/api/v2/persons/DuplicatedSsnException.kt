package com.api.v2.persons

class DuplicatedSsnException: RuntimeException("The given SSN is already registered.")
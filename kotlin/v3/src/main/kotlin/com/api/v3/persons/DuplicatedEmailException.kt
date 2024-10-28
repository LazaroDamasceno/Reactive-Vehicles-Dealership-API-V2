package com.api.v3.persons

import java.lang.RuntimeException

class DuplicatedEmailException: RuntimeException("The given email is already registered.")
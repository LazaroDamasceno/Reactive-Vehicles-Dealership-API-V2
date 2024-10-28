package com.api.v2.persons.annotations;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 9, max = 9)
public @interface SSN {
    String message() default "Invalid SSN format. Please enter a 9-digit Social Security Number.";
}
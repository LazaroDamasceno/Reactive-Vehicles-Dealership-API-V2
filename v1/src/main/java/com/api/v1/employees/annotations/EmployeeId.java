package com.api.v1.employees.annotations;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 7, max = 7)
public @interface EmployeeId {
    String message() default "Invalid Employee Id format. Please enter a 7-digit Employee Id.";
}
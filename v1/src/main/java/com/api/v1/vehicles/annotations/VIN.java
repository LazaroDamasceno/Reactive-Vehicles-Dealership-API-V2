package com.api.v1.vehicles.annotations;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 17, max = 17)
public @interface VIN {
    String message() default "Invalid VIN format. Please enter a 17-digit Vehicle Identification Number.";
}
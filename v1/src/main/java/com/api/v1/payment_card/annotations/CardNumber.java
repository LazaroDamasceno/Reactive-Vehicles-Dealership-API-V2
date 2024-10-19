package com.api.v1.payment_card.annotations;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 16, max = 16)
public @interface CardNumber {
    String message() default "Invalid card number format. Please enter a 16-digit Card Number.";
}
package com.example.customannotation.annotation;

import com.example.customannotation.aspect.AlphabeticValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AlphabeticValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphabetic {
    String message() default "Field must contain only alphabetic characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

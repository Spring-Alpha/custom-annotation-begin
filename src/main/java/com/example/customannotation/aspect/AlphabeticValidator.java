package com.example.customannotation.aspect;

import com.example.customannotation.annotation.Alphabetic;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AlphabeticValidator implements ConstraintValidator<Alphabetic, String> {
    @Override
    public void initialize(Alphabetic constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("[a-zA-Z]+");
    }
}

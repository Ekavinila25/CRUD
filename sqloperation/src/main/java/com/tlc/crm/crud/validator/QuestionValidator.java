package com.tlc.crm.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validates the Question.
 */
public class QuestionValidator implements ConstraintValidator<Question, String> {

    /**
     * Validates the answer which contain the character between 3 to 50.
     *
     * @param value
     * @param context
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value.length() >= 3 & value.length() <= 50);
    }
}


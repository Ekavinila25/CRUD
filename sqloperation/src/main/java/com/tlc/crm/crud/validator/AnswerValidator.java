package com.tlc.crm.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validates the answer.
 */
public class AnswerValidator implements ConstraintValidator<Answer, String> {

    /**
     * Validates the question which contain the character between 3 to 50.
     *
     * @param value
     * @param context
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value.length() >= 3 & value.length() <= 50);
    }
}

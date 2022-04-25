package com.tlc.crm.crud.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuestionValidator.class)
@Documented
public @interface Question {

    String message() default "validator_error_invalid_question";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

package com.tlc.crm.crud.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AnswerValidator.class)
@Documented
public @interface Answer {

    String message() default "validator_error_invalid_answer";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


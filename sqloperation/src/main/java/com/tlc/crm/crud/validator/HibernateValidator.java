package com.tlc.crm.crud.validator;

import com.tlc.commons.code.ErrorCode;
import com.tlc.crm.crud.model.ChatBot;
import com.tlc.crm.crud.status.ChatErrorCode;
import com.tlc.validator.ModelValidator;
import com.tlc.validator.ValidatorAccess;

/**
 * Validate the input.
 *
 * @author KavinilaE
 */
public class HibernateValidator {

    private static final ModelValidator MODEL_VALIDATOR = ValidatorAccess.get();

    /**
     * Validate the chatbot object.
     *
     * @param clazz
     */
    public static void validate(final ChatBot chatBot, final Class... clazz) {

        if (!MODEL_VALIDATOR.isValid(chatBot, clazz)) {
            throw ErrorCode.get(ChatErrorCode.FAILED_TO_VALIDATE);
        }
    }
}


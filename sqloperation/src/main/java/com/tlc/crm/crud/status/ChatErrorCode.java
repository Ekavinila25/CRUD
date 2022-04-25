package com.tlc.crm.crud.status;

import com.tlc.commons.code.ErrorCodeGroup;
import com.tlc.commons.code.ErrorCodeProvider;

/**
 * Provides the ErrorCode for chatbot.
 *
 * @author KavinilaE
 */
public enum ChatErrorCode implements ErrorCodeProvider {

    FAILED_TO_UPDATE_RECORD(0x02),
    FAILED_TO_DELETE_RECORD(0x04),
    FAILED_TO_VALIDATE(0x05);

    private final int CODE;

    ChatErrorCode(int code) {
        this.CODE = ChatErrorCodeGroup.ERROR_CODE_GROUP.getConvertedCode(code);
    }

    /**
     * Get the chatbot error code.
     */
    @Override
    public int getCode() {
        return CODE;
    }

    /**
     * Creating an ErrorCodeGroup
     */
    private static class ChatErrorCodeGroup implements ErrorCodeGroup {

        private static final ErrorCodeGroup ERROR_CODE_GROUP = new ChatErrorCodeGroup();

        @Override
        public int getPrefix() {
            return 0x10_0_0000;
        }
    }
}

package com.vincent.clinic.global.code;

import com.vincent.clinic.global.error.exception.BusinessException;

public class InvalidRequestValueException extends BusinessException {

    public InvalidRequestValueException(String message) {
        super(message, ErrorCode.INVALID_REQUEST_VALUE);
    }
    public InvalidRequestValueException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }
}

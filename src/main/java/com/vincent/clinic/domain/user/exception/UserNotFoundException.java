package com.vincent.clinic.domain.user.exception;


import com.vincent.clinic.global.code.ErrorCode;
import com.vincent.clinic.global.error.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(String message) {
        super(message, ErrorCode.USER_NOT_FOUND);
    }

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}

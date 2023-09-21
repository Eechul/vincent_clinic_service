package com.vincent.clinic.global.code;

import com.vincent.clinic.global.error.exception.BusinessException;

public class IntervalServerErrorException extends BusinessException {

    public IntervalServerErrorException(String message) {
        super(message, ErrorCode.INTERNAL_SERVER_ERROR);
    }
    public IntervalServerErrorException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

}

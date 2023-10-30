package com.vincent.clinic.domain.clinic.exception;

import com.vincent.clinic.global.code.ErrorCode;
import com.vincent.clinic.global.error.exception.BusinessException;

public class NotFoundClinicException extends BusinessException {

    public NotFoundClinicException() {
        super("진료일지를 찾을 수 없습니다.", ErrorCode.CLINIC_NOT_FOUND);
    }
}

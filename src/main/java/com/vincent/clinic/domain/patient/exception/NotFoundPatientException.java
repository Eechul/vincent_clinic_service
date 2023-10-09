package com.vincent.clinic.domain.patient.exception;

import com.vincent.clinic.global.code.ErrorCode;
import com.vincent.clinic.global.error.exception.BusinessException;

public class NotFoundPatientException extends BusinessException {

    public NotFoundPatientException() {
        super("환자를 찾을 수 없습니다.", ErrorCode.PATIENT_NOT_FOUND);
    }
}

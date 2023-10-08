package com.vincent.clinic.domain.department.exception;

import com.vincent.clinic.global.code.ErrorCode;
import com.vincent.clinic.global.error.exception.BusinessException;

public class NotFoundDepartmentException extends BusinessException {

    public NotFoundDepartmentException() {
        super("부서를 찾을 수 없습니다.", ErrorCode.DEPARTMENT_NOT_FOUND);
    }
}

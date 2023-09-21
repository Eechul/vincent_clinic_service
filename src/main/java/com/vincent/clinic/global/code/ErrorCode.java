package com.vincent.clinic.global.code;

public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "CM001", "잘못된 입력값 입니다."),
    METHOD_NOT_ALLOWED(405, "CM002", "잘못된 HTTP method 입니다."),
    ENTITY_NOT_FOUND(400, "CM003", "찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "CM004", "서버와의 연결이 원할하지 않습니다."),
    INVALID_TYPE_VALUE(400, "CM005", "잘못된 입력값 입니다."),
    INVALID_REQUEST_VALUE(400, "CM008", "잘못된 요청입니다."),

    // User
    USER_NOT_FOUND(400, "USR001", "유저를 찾을 수 없습니다.")
    ;

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}

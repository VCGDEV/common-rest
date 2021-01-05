package com.vcgdev.common.exception;

public enum ErrorCode {
    
    INTERNAL(500, "Could not process request"),
	BAD_REQUEST(400, "Invalid parameters"),
    NOT_FOUND(404, "Not found"),
    CONFLICT(409, "Conflict");
    
    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.vcgdev.common.exception;

public class ErrorDetail {

    private String code;
    private String reason;

    public ErrorDetail() {}

    public ErrorDetail(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
}

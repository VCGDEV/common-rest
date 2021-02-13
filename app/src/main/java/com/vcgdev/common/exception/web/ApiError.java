package com.vcgdev.common.exception.web;

import java.util.ArrayList;
import java.util.List;

import com.vcgdev.common.exception.ErrorCode;
import com.vcgdev.common.exception.ErrorDetail;

public class ApiError {
    private String code;
    private String message;
	private List<ErrorDetail> errors;
	
    public ApiError(ErrorCode errorCode) {
        this.code = errorCode.getCode().toString();
        this.message = errorCode.getMessage();
        this.errors = new ArrayList<>();
    }

    public ApiError() {
        this.errors = new ArrayList<>();
    }

	public void addError(ErrorDetail detail) {
		errors.add(detail);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }
}

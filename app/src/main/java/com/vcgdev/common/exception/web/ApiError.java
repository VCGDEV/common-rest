package com.vcgdev.common.exception.web;

import java.util.List;

import com.vcgdev.common.exception.ErrorCode;
import com.vcgdev.common.exception.ErrorDetail;

public class ApiError {
    private ErrorCode code;
	private List<ErrorDetail> errors;
	
	public void addError(ErrorDetail detail) {
		errors.add(detail);
    }
    
    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }
}

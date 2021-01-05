package com.vcgdev.common.exception;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends Exception {

    static final long serialVersionUID = 1L;
    
    private final ErrorCode code;
    private final List<ErrorDetail> errors = new ArrayList<>();

    public void addError(ErrorDetail error) {
        this.errors.add(error);
    }

    public ServiceException(ErrorCode errCode, String code, String reason){
        this.code = errCode;
        this.addError(new ErrorDetail(code, reason));
    }

    public ServiceException(ErrorCode code) {
		super(code.getMessage());
		this.code = code;
    }
    
    public ErrorCode getCode() {
        return code;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }
    
}

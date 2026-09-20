package com.example.tripservice.modules.shared.domain.core.dto;

import com.example.tripservice.modules.shared.domain.core.error_code.ErrorCode;

public class ApiException extends RuntimeException {
    private final ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
    }

    public ApiException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessageKey(), cause);
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return this.errorCode;
    };
}

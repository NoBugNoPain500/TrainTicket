package com.example.tripservice.modules.shared.domain.core.error_code;

public enum CommonErrorCode implements ErrorCode {
    DATA_VIOLATION("common.data_violation", 409);

    private final String messageKey;
    private final int httpStatus;

    CommonErrorCode(String messageKey, int httpCode) {
        this.messageKey = messageKey;
        this.httpStatus = httpCode;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessageKey() {
        return this.messageKey;
    }

    @Override
    public int getHttpCode() {
        return this.httpStatus;
    }
}
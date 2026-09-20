package com.example.tripservice.modules.station.domain.valueobjects;

import com.example.tripservice.modules.shared.domain.core.error_code.ErrorCode;

public enum StationErrorCode implements ErrorCode {
    STATION_NOT_FOUND("station.not_found", 404),
    DUPLICATE_STATION_NAME("station.duplicated_name", 409),
    DUPLICATE_STATION_CODE("station.duplicated_code", 409);

    private final String messageKey;
    private final int httpStatus;

    StationErrorCode(String messageKey, int httpCode) {
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

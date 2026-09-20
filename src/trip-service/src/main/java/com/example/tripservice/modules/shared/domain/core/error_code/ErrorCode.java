package com.example.tripservice.modules.shared.domain.core.error_code;


public interface ErrorCode {

    String getCode();

    String getMessageKey();

    int getHttpCode();
}

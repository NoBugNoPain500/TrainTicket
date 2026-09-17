package com.example.movieservice.modules.shared.domain.core;

public interface BusinessErrorCode {
        String getCode();

        String getMessage();

        int getHttpStatus();
}

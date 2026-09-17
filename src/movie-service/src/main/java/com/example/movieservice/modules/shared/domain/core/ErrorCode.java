package com.example.movieservice.modules.shared.domain.core;

public enum ErrorCode {
    ;
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.name();
    }

    public String getMessage() {
        return this.message;
    }
}

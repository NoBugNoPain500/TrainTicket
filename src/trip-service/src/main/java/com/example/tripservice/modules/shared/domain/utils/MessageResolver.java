package com.example.tripservice.modules.shared.domain.utils;

public interface MessageResolver {
    String getMessage(String code, Object... args);
}

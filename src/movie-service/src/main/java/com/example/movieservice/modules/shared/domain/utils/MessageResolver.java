package com.example.movieservice.modules.shared.domain.utils;

public interface MessageResolver {
    String getMessage(String code, Object... args);
}

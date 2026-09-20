package com.example.tripservice.modules.shared.presentation.rest.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse<T> {
    private boolean isSuccess;
    private String errorCode;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success( String message, T data) {
        return ApiResponse.<T>builder()
                .isSuccess(true)
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse<Void> failure(String errorCode, String message) {
        return new ApiResponse<>(
                false,
                errorCode,
                message,
                null
        );
    }
}

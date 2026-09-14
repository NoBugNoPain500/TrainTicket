package com.example.movieservice.modules.shared.api.dto;

public class ApiResponse<T> {
    private int businessCode;
    private String message;
    private T data;

    public ApiResponse(int businessCode, String message, T data) {
        this.businessCode = businessCode;
        this.message = message;
        this.data = data;
    }

    public int getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(int businessCode) {
        this.businessCode = businessCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

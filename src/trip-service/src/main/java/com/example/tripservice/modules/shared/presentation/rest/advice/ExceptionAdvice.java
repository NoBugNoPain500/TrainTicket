package com.example.tripservice.modules.shared.presentation.rest.advice;

import com.example.tripservice.modules.shared.domain.core.dto.ApiException;
import com.example.tripservice.modules.shared.domain.core.error_code.ErrorCode;
import com.example.tripservice.modules.shared.domain.utils.MessageResolver;
import com.example.tripservice.modules.shared.presentation.rest.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    private final MessageResolver messageResolver;

    public ExceptionAdvice(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse<Void>> apiExceptionHandler(ApiException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        String message = messageResolver.getMessage(
                errorCode.getMessageKey()
        );
        log.info(exception.getCause().toString());
        return ResponseEntity
                .status(errorCode.getHttpCode())
                .body(
                        ApiResponse.failure(
                                errorCode.getCode(),
                                message)
                );
    }

}

package com.example.movieservice.modules.shared.presentation.rest.advice;

import com.example.movieservice.modules.shared.domain.annotations.SuccessResponse;
import com.example.movieservice.modules.shared.domain.utils.MessageResolver;
import com.example.movieservice.modules.shared.presentation.rest.dto.ApiResponse;
import com.example.movieservice.modules.shared.domain.annotations.NoWrap;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    private final MessageResolver messageResolver;

    @Override
    public boolean supports(MethodParameter returnType,
                            @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.hasMethodAnnotation(NoWrap.class);
    }

    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body,
                                            @NonNull MethodParameter returnType,
                                            @NonNull MediaType selectedContentType,
                                            @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                            @NonNull ServerHttpRequest request,
                                            @NonNull ServerHttpResponse response) {
           if (body instanceof String) {
               return body;
           }
           SuccessResponse successResponse = returnType.getMethodAnnotation(SuccessResponse.class);
           String message = "Success";
           if (successResponse != null) {
               message = messageResolver.getMessage(successResponse.message());
           }
           return ApiResponse.success(message, body);
    }
}

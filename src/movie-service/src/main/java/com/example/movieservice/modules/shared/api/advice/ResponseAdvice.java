package com.example.movieservice.modules.shared.api.advice;

import com.example.movieservice.modules.shared.api.dto.ApiResponse;
import com.example.movieservice.modules.shared.domain.annotations.NoWrap;
import com.example.movieservice.modules.shared.domain.annotations.ResponseInfo;
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
public class ResponseAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType,
                            @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.hasMethodAnnotation(NoWrap.class);
    }

    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body,
                                            MethodParameter returnType,
                                            @NonNull MediaType selectedContentType,
                                            @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                            @NonNull ServerHttpRequest request,
                                            @NonNull ServerHttpResponse response) {
            ResponseInfo responseInfo = returnType.getMethodAnnotation(ResponseInfo.class);
            if (responseInfo == null) {
                return body;
            }
            int businessCode = responseInfo.businessCode();
            String message = responseInfo.message();
            return new ApiResponse<>(
                    businessCode,
                    message,
                    body
            );
    }
}

package com.example.tripservice.modules.shared.domain.exceptions;

import com.example.tripservice.modules.shared.domain.core.dto.ApiException;
import com.example.tripservice.modules.shared.domain.core.error_code.ErrorCode;

public class DuplicateException extends ApiException {
    public DuplicateException(ErrorCode code, Throwable cause) {
        super(code, cause);
    }

    public DuplicateException(ErrorCode code) {
        super(code);
    }
}

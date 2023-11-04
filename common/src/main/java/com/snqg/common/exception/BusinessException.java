package com.snqg.common.exception;

import com.snqg.domain.enums.ErrorCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
// 业务异常
public class BusinessException extends RuntimeException{

    private final int code;

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                "} " + super.toString();
    }
}


package com.snqg.common.exception;


import com.snqg.domain.enums.ErrorCode;
import org.springframework.web.bind.annotation.ResponseStatus;

//参数校验异常
@ResponseStatus
public class ValidationException extends BusinessException{

    public ValidationException(String message) {
        super(ErrorCode.ILLEGAL_PARAM_ERROR, message);
    }

}

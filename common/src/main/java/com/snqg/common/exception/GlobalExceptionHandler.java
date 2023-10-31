package com.snqg.common.exception;

import com.snqg.domain.enums.ErrorCode;
import com.snqg.domain.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Response<Void> businessExceptionHandler(BusinessException e) {
        log.error("业务异常：" + e);
        return Response.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Response<Void> runtimeExceptionHandler(RuntimeException e) {
        log.error("系统异常：" + e);
        return Response.error(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }

}

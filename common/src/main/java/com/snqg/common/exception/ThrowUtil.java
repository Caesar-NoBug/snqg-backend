package com.snqg.common.exception;
import com.snqg.domain.enums.ErrorCode;
import com.snqg.common.util.StrUtil;

import java.util.Objects;

public class ThrowUtil {

    //如果条件满足则抛出异常
    public static void throwIf(boolean isThrow, RuntimeException e) {
        if (isThrow) throw e;
    }

    public static void throwIf(boolean isThrow, ErrorCode errorCode, String message) {
        throwIf(isThrow, errorCode.getCode(), message);
    }

    public static void throwIf(boolean isThrow, int code, String message) {
        if (isThrow) throw new BusinessException(code, message);
    }

    public static void throwIf(boolean isThrow, String message) {
        if (isThrow) throw new BusinessException(ErrorCode.ILLEGAL_PARAM_ERROR, message);
    }

    /**
     * @param validation 校验结果是否合法
     * @param message 错误信息
     * throw 校验异常
     */
    public static void validate(boolean validation,  String message) {
        if(!validation) throw new ValidationException(message);
    }

    /**
     * 若对象为空则抛出异常
     * @param object 待校验对象
     * @param message 抛出的异常信息
     */
    public static void throwIfNull(Object object, String message) {
        if(Objects.isNull(object))
            throw new BusinessException(ErrorCode.ILLEGAL_PARAM_ERROR, message);
    }

    /**
     * 若字符串不符合要求则抛出异常
     * @param string 待校验字符串
     * @param message 错误信息
     */
    public static void throwTestStr(String string, String message) {
        if(!StrUtil.checkString(string))
            throw new BusinessException(ErrorCode.ILLEGAL_PARAM_ERROR, message);
    }

    /**
     * 若字符串不符合要求则抛出异常
     * @param string 待校验字符串
     * @param maxLength 待校验字符串允许的最大长度
     * @param message 错误信息
     */
    public static void throwTestStr(String string, int maxLength, String message) {
        if(!StrUtil.checkString(string, maxLength))
            throw new BusinessException(ErrorCode.ILLEGAL_PARAM_ERROR, message);
    }

}

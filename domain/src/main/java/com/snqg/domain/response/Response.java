package com.snqg.domain.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.snqg.domain.enums.ErrorCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Response<T>{

    @ApiModelProperty(value = "状态码", example = "200")
    private int code;
    @ApiModelProperty(value = "数据", example = "{name:'caesar',password:'2334'}")
    private T data;
    @ApiModelProperty(value = "提示信息", example = "请求成功")
    private String msg;

    public static <T> Response<T> ok(T data){
        return new Response<T>(ErrorCode.SUCCESS.getCode(), data, "请求成功");
    }

    public static <T> Response<T> ok(T data, String msg){
        return new Response<T>(ErrorCode.SUCCESS.getCode(), data, msg);
    }

    public static Response<Void> error(ErrorCode errorCode, String msg){
        return new Response<>(errorCode.getCode(), null, msg);
    }

    public static Response<Void> error(int code, String msg){
        return new Response<>(code, null, msg);
    }

    public static <T> Response<T> error(String msg){
        return new Response<>(ErrorCode.ILLEGAL_PARAM_ERROR.getCode(), null, msg);
    }

}

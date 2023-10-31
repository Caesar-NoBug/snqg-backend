package com.snqg.domain.request.children;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WxLoginRequest {
    @ApiModelProperty(value = "用户授权登录获取的token", example = "fwewe4235ID5-ds2")
    private String code;
}

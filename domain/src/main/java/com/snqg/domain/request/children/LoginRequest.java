package com.snqg.domain.request.children;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginRequest {
    @ApiModelProperty(value = "用户授权登录获取的token", example = "FweWe4235ID5-ds2")
    private String code;

    @ApiModelProperty(value = "儿童邀请码", example = "EA3T7F")
    private String inviteCode;
}

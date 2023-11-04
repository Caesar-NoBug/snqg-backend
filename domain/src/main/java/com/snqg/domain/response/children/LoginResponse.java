package com.snqg.domain.response.children;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class LoginResponse {

    @ApiModelProperty(value = "认证token，后续请求都使用这个token来进行认证,这个token是可用的测试token", example = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0N2E3YzQ0MWVmYjg0OGFjOTI4MTFlNTAwNDkyYTE5MSIsInN1YiI6Im8ySEVONWExLTYyQUwxU0RjMThnNGxXN1BRVWciLCJpc3MiOiJzZyIsImlhdCI6MTY5OTAxMTEyMCwiZXhwIjoxNjk5MDE0NzIwfQ.3yAo8ID_R6iLYEI2FoWU3VbJ0YQjXXcTq6FxAzxNQRE")
    private String token;

    @ApiModelProperty(value = "用户id", example = "o2HEN5a1-62AL1SDc18g4lW7PQUg")
    private String id;

    @ApiModelProperty(value = "用户名", example = "儿童1号")
    private String username;

    @ApiModelProperty(value = "用户角色(1:管理员 2:志愿者 3:儿童)", example = "1")
    private Integer role;

    @ApiModelProperty(value = "用户头像", example = "https://baidu.com/a.png")
    private String avatar;

    @ApiModelProperty(value = "性别(1:男 2:女)", example = "2")
    private Integer gender;

    @ApiModelProperty(value = "地址", example = "辽宁省沈阳市浑南区东北大学")
    private String address;

    @ApiModelProperty(value = "生日", example = "1699096038369")
    private Date birth;

}

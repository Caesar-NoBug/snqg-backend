package com.snqg.domain.response.children;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginResponse {

    @ApiModelProperty(value = "认证token，后续请求都使用这个token来进行认证,这个token是可用的测试token", example = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwMDVlY2EzZTU3ODg0Y2FiOWJlN2RkZDVhZDJlYTIwYiIsInN1YiI6Im8ySEVONWExLTYyQUwxU0RjMThnNGxXN1BRVWciLCJpc3MiOiJzZyIsImlhdCI6MTY5ODk5MTMyNCwiZXhwIjoxNjk4OTk0OTI0fQ.0xLaNu-JAeXXkNNTVtB4W35vcBWtN8brJeWBgmk1K9s")
    private String token;

    @ApiModelProperty(value = "用户id", example = "o2HEN5a1-62AL1SDc18g4lW7PQUg")
    private String id;

    @ApiModelProperty(value = "用户名", example = "儿童1号")
    private String username;

    @ApiModelProperty(value = "用户角色", example = "1:管理员 2:志愿者 3:儿童")
    private Integer role;

    @ApiModelProperty(value = "用户头像", example = "https://baidu.com/a.png")
    private String avatar;

    @ApiModelProperty(value = "性别", example = "1:男 2:女")
    private Integer gender;

    @ApiModelProperty(value = "地址", example = "辽宁省沈阳市浑南区东北大学")
    private String address;

    @ApiModelProperty(value = "生日", example = "1970-01-01T19:26:02.928")
    private LocalDateTime birth;

}

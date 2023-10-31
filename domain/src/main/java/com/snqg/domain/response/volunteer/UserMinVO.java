package com.snqg.domain.response.volunteer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserMinVO {
    @ApiModelProperty(value = "用户id", example = "12423")
    private Long id;
    @ApiModelProperty(value = "用户id", example = "erwe45345fg34")
    private String openid;
    @ApiModelProperty(value = "用户名", example = "儿童1号")
    private String name;
    @ApiModelProperty(value = "用户类型", example = "1:管理员 2:志愿者 3:儿童")
    private Integer type;
    @ApiModelProperty(value = "用户头像", example = "https://baidu.com/a.png")
    private String avatar;
}

package com.snqg.domain.response.children;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChildrenVO {

    @ApiModelProperty(value = "用户微信id", example = "erwe45345fg34")
    private String wechatId;

    @ApiModelProperty(value = "用户名", example = "儿童1号")
    private String name;

    @ApiModelProperty(value = "用户角色", example = "1:管理员 2:志愿者 3:儿童")
    private Integer role;

    @ApiModelProperty(value = "用户头像", example = "https://baidu.com/a.png")
    private String avatar;

    @ApiModelProperty(value = "性别", example = "1:男 2:女")
    private Integer gender;

    @ApiModelProperty(value = "地址", example = "辽宁省沈阳市浑南区东北大学")
    private String address;

    @ApiModelProperty(value = "地址", example = "辽宁省沈阳市浑南区东北大学")
    private Integer age;
}

package com.snqg.desire.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//返回添加感谢内容成功与否
@Data
public class ModifyThanksResponse {

    @ApiModelProperty(value = "message",example = "已修改/提示未完成的愿望无法感谢")
    private String message;
}

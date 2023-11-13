package com.snqg.desire.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//返回修改愿望成功与否
@Data
public class ModifyDesireResponse {

    @ApiModelProperty(value = "message",example = "已修改/提示已完成的愿望无法修改")
    private String message;
}

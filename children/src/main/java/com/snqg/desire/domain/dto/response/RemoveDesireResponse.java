package com.snqg.desire.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//返回删除愿望成功与否
@Data
public class RemoveDesireResponse {

    @ApiModelProperty(value = "message",example = "成功")
    private String message;
}

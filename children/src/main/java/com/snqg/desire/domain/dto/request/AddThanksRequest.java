package com.snqg.desire.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//添加感谢请求
@Data
public class AddThanksRequest {

    @ApiModelProperty(value = "愿望id",example = "1145")
    private int id;

    @ApiModelProperty(value = "感谢内容",example = "谢谢你！你是好人！")
    private String thanks;

}

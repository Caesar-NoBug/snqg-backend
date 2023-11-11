package com.snqg.desire.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ThanksVo {

    @ApiModelProperty(value = "感谢内容",example = "谢谢你！你是好人！")
    private String thanks;
}

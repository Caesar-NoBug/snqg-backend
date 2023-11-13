package com.snqg.desire.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//返回某个child对于某个已完成愿望的感谢
@Data
public class GetThanksResponse {

    @ApiModelProperty(value = "感谢的具体内容",example = "谢谢你！你是好人！")
    private String thanks;

}

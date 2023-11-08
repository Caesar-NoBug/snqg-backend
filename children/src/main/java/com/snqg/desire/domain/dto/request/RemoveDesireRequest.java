package com.snqg.desire.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//删除某个（未完成的）愿望的请求
@Data
public class RemoveDesireRequest {

    @ApiModelProperty(value = "愿望id",example = "1145")
    private int id;

}

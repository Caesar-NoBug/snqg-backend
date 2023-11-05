package com.snqg.desire.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//请求某个学生的所有愿望详细信息
@Data
public class AllDesireRequest {

    @ApiModelProperty(value = "儿童id",example = "123")
    private String chileId;
}

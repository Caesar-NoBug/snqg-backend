package com.snqg.desire.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
//增加愿望请求
@Data
public class AddDesireRequest {

    @ApiModelProperty(value = "儿童id",example = "123")
    private String chileId;

    @ApiModelProperty(value = "愿望标题",example = "想要一本词典")
    private String title;

    @ApiModelProperty(value = "愿望详情",example = "我想用词典查不认识的字")
    private String desc;

}

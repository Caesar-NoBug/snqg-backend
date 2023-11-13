package com.snqg.desire.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//修改愿望信息的请求
@Data
public class ModifyDesireRequest {

    @ApiModelProperty(value = "愿望id",example = "1145")
    private int id;

    @ApiModelProperty(value = "愿望标题",example = "想要一本词典")
    private String title;

    @ApiModelProperty(value = "愿望详情",example = "我想用词典查不认识的字")
    private String desc;

    //已完成的愿望无法被修改
    //@ApiModelProperty(value = "愿望是否完成",example = "true")
    //private boolean progress;
}

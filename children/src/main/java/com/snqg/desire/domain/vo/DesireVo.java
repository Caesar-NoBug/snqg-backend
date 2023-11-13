package com.snqg.desire.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DesireVo {

    @ApiModelProperty(value = "愿望id",example = "1145")
    private int id;

    @ApiModelProperty(value = "愿望标题",example = "想要一本词典")
    private String title;

    @ApiModelProperty(value = "愿望详情",example = "我想用词典查不认识的字")
    private String detail;

    @ApiModelProperty(value = "愿望是否完成",example = "true")
    private int progress;

    /*
    @ApiModelProperty(value = "感谢的内容",example = "你是好人，谢谢你")
    private String thanks;
     */


}

package com.snqg.point.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RankPercentageVO {

    @ApiModelProperty(value = "记录时间", example = "2023-05-10")
    String recordTime;
    @ApiModelProperty(value = "积分排名百分比（小数）", example = "0.86")
    double rankPercentage;

}

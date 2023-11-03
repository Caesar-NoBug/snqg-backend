package com.snqg.point.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PointStatus {
    @ApiModelProperty(value = "用户自己的积分个数", example = "20")
    private int userPoint; // 用户自己的积分个数
    @ApiModelProperty(value = "整个系统积分的平均值", example = "18")
    private double systemAverageTaskCount; // 整个系统积分的平均值
}

package com.snqg.point.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PointStatusVO {
    @ApiModelProperty(value = "积分获取量时间范围（图表x轴）", example = "2023-01-01")
    private String recordTime; // 记录时间
    @ApiModelProperty(value = "积分获取量（图表y轴）", example = "20")
    private int childPoint; // 用户自己的积分个数
    @ApiModelProperty(value = "整个系统积分获取量的平均值（图表y轴）", example = "18")
    private double systemAverage; // 整个系统积分的平均值
}

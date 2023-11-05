package com.snqg.point.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TaskStatusVO {
    @ApiModelProperty(value = "任务记录时间", example = "2023-01-01")
    private String recordTime; // 记录时间
    @ApiModelProperty(value = "用户自己的完成任务个数", example = "20")
    private int userTaskCount; // 用户自己的完成任务个数
    @ApiModelProperty(value = "整个系统完成任务的个数的平均值", example = "18")
    private double systemAverageTaskCount; // 整个系统完成任务的个数的平均值
}

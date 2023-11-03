package com.snqg.point.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class PointVO {
    @ApiModelProperty(value = "用户id", example = "12423")
    private String userId;

    @ApiModelProperty(value = "积分改变量", example = "18")
    private Integer changedPoint;

    @ApiModelProperty(value = "积分改变时间", example = "2023-11-02")
    private LocalDateTime changeTime;

    @ApiModelProperty(value = "任务描述", example = "记忆60个单词")
    private String taskDesc;
}

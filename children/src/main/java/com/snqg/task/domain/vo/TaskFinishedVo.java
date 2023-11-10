package com.snqg.task.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskFinishedVo {
    @ApiModelProperty(value = "任务id",example = "1234")
    private int id;

    @ApiModelProperty(value = "任务标题",example = "请回答这道数学问题")
    private String title;

    @ApiModelProperty(value = "任务类型",example = "数学")
    private String type;

    @ApiModelProperty(value = "任务具体内容",example = "1+2=")
    private String detail;

    @ApiModelProperty(value = "任务图片url",example = "abcdefg")
    private String taskUrl;

    @ApiModelProperty(value = "任务完成时间", example = "2019-01-21T05:47:08.644")
    private LocalDateTime taskFinishTime;
}

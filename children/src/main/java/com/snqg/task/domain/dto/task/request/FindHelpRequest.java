package com.snqg.task.domain.dto.task.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindHelpRequest {

    @ApiModelProperty(value = "childId", example = "1234")
    private int childId;
    @ApiModelProperty(value = "taskId", example = "123")
    private int id;
    @ApiModelProperty(value = "taskContent", example = "任务完成了!")
    private String detail;
    @ApiModelProperty(value = "pictureUrl", example = "图片的Url")
    private String taskUrl;
    @ApiModelProperty(value = "任务完成时改变的积分", example = "比如10")
    private int changePoint;
}

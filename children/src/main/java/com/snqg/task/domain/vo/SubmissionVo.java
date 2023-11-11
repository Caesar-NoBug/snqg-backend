package com.snqg.task.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubmissionVo {
    @ApiModelProperty(value = "这是某个内容的id",example = "1234")
    private Integer id;

    @ApiModelProperty(value = "儿童的id",example = "1234")
    private String childId;

    @ApiModelProperty(value = "任务的id",example = "1234")
    private Integer taskId;

    @ApiModelProperty(value = "请求的内容",example = "1234")
    private String content;

    @ApiModelProperty(value = "请求的提交时间",example = "1234")
    private LocalDateTime submitTime;
}

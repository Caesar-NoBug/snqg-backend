package com.snqg.task.domain.dto.submission.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SendTaskFinishRequest {
    @ApiModelProperty(value = "childId", example = "123")
    private int childId;

    @ApiModelProperty(value = "helpContent", example = "我想请问1+1等于几")
    private String content;
}

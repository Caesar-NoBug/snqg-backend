package com.snqg.task.domain.dto.submission.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GiveFeedbackResponse {
    @ApiModelProperty(value = "返回值true表示求助成功，请耐心等待志愿者回信。\n" +
            "返回值false表示求助失败，可能该小孩尚未绑定志愿者", example = "12345")
    private boolean volunteer;
}

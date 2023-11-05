package com.snqg.task.domain.dto.task.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindHelpFeedbackResponse {

    @ApiModelProperty(value = "boolean", example = "True")
    private boolean yesOrNo;
}

package com.snqg.task.domain.dto.task.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindHelpFeedbackResponse {

    @ApiModelProperty(value = "找人帮忙是否成功，true表示成功，false表示失败", example = "True")
    private boolean yesOrNo;
}

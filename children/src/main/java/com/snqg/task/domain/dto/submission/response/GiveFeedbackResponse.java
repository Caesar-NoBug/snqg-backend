package com.snqg.task.domain.dto.submission.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GiveFeedbackResponse {
    @ApiModelProperty(value = "volunteerId", example = "12345")
    private int volunteer;
}

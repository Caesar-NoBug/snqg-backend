package com.snqg.task.domain.dto.task.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetTaskRequset {
    @ApiModelProperty(value = "childId", example = "1234")
    private int childId;
}

package com.snqg.point.domain.dto.point.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PointHistoryRequest {
    @ApiModelProperty(value = "type", example = "1")
    private String type;
}

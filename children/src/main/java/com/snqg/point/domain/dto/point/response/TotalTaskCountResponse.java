package com.snqg.point.domain.dto.point.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TotalTaskCountResponse {
    @ApiModelProperty(value = "累计任务完成个数", example = "100")
    private int totalTaskCount;
}

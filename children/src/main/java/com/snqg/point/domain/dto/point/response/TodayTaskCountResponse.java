package com.snqg.point.domain.dto.point.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TodayTaskCountResponse {
    @ApiModelProperty(value = "今日任务完成个数", example = "100")
    private int todayTaskCount;
}

package com.snqg.point.domain.dto.point.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TodayPointCountResponse {
    @ApiModelProperty(value = "今日积分获取个数", example = "100")
    private int todayPointCount;
}

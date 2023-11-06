package com.snqg.point.domain.dto.point.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RankingRequest {
    @ApiModelProperty(value = "时间范围（total:总积分，year:年度积分，month:月度积分，week:周积分）", example = "total")
    private String timeRange;
    @ApiModelProperty(value = "排序范围（system:系统范围内进行排名，group:小组范围内进行排名）", example = "group")
    private String rankingRange;
}

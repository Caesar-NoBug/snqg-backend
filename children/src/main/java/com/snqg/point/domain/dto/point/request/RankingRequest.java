package com.snqg.point.domain.dto.point.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RankingRequest {
    @ApiModelProperty(value = "timeRange", example = "total")
    private String timeRange;
    @ApiModelProperty(value = "rankingRange", example = "group")
    private String rankingRange;
}

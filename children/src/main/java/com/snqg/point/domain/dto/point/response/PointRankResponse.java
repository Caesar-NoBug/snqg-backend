package com.snqg.point.domain.dto.point.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PointRankResponse {

    @ApiModelProperty(value = "积分排名", example = "23")
    private int pointRank;
}

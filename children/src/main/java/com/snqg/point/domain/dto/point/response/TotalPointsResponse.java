package com.snqg.point.domain.dto.point.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TotalPointsResponse {
    @ApiModelProperty(value = "积分总额", example = "11290")
    private int totalPoint;
}

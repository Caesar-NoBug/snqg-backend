package com.snqg.point.domain.dto.point.response;

import com.snqg.point.domain.vo.RankPercentageVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PointRankPercentageResponse {
    @ApiModelProperty(value = "积分排名百分比（小数）", example = "")
    private List<RankPercentageVO> rankPercentageList;
}

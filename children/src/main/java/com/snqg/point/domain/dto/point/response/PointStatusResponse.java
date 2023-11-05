package com.snqg.point.domain.dto.point.response;

import com.snqg.point.domain.vo.PointStatusVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PointStatusResponse {
    @ApiModelProperty(value = "返回积分绘图数据列表")
    private List<PointStatusVO> pointStatusVOList;
}

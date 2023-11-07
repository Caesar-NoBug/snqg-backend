package com.snqg.point.domain.dto.point.response;

import com.snqg.point.domain.vo.PointStatusVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PointStatusResponse {

    @ApiModelProperty(value = "返回积分获取情况数据列表，用于绘图")
    private List<PointStatusVO> pointStatusVOList;

}

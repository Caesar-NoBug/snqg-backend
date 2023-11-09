package com.snqg.point.domain.dto.point.response;

import com.snqg.point.domain.vo.PointVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PointHistoryResponse {

    @ApiModelProperty(value = "积分获取记录列表", example = "")
    private List<PointVO> pointRecords;
}

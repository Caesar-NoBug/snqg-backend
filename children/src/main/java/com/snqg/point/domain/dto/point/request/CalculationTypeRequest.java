package com.snqg.point.domain.dto.point.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CalculationTypeRequest {
    @ApiModelProperty(value = "请求：积分商城界面之中显示积分的剩余值和积分排名界面之中显示积分的累计值；" +
            "参数功能：选择要显示剩余积分还是累计积分；" +
            "计算积分剩余值，可以用于显示剩余积分或者累计积分；" +
            "要显示剩余积分，传入\"remaining\"" +
            "要显示累计积分，传入\"accumulated\"", example = "accumulated")
    private String calculationType;
}

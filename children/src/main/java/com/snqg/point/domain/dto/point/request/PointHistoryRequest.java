package com.snqg.point.domain.dto.point.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PointHistoryRequest {
    @ApiModelProperty(value = "请求：在积分商城界面之中显示积分收支记录（和不背单词之中的界面很像）；" +
            "参数功能：限定范围，获取积分记录时，可以选择显示:" +
            "1)\"all\", 显示全部积分记录" +
            "2)\"expense\", 仅显示积分支出记录" +
            "3)\"income\", 仅显示积分收入记录", example = "all")
    private String type;
}

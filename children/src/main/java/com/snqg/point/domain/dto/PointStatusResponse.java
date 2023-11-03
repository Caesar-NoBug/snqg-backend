package com.snqg.point.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointStatusResponse {
    private int userPoint; // 用户自己的积分个数
    private double systemAverageTaskCount; // 整个系统积分的平均值
}

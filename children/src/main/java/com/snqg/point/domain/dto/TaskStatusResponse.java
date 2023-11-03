package com.snqg.point.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatusResponse {
    private int userTaskCount; // 用户自己的完成任务个数
    private double systemAverageTaskCount; // 整个系统完成任务的平均值
}

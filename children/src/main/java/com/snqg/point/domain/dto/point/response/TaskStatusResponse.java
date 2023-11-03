package com.snqg.point.domain.dto.point.response;

import com.snqg.point.domain.dto.point.response.PointStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TaskStatusResponse {
    @ApiModelProperty(value = "返回完成任务数量列表")
    private List<PointStatus> pointStatusResponseList;
}

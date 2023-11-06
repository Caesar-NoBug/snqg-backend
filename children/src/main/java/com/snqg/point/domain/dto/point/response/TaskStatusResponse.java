package com.snqg.point.domain.dto.point.response;

import com.snqg.point.domain.vo.TaskStatusVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TaskStatusResponse {
    @ApiModelProperty(value = "返回任务完成数量列表，用于绘图")
    private List<TaskStatusVO> taskStatusVOList;
}

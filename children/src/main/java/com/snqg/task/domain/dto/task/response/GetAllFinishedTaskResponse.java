package com.snqg.task.domain.dto.task.response;

import com.snqg.task.domain.vo.TaskFinishedVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetAllFinishedTaskResponse {
    @ApiModelProperty(value = "任务信息列表,以数组形式返回所有已经完成的任务信息",example = "")
    private List<TaskFinishedVo> taskFinishedVos;
}

package com.snqg.task.domain.dto.task.response;

import com.snqg.task.domain.vo.TaskVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetTaskResponse {

    @ApiModelProperty(value = "任务信息列表,以数组形式返回任务信息",example = "")
    private List<TaskVo> taskVoList;
}

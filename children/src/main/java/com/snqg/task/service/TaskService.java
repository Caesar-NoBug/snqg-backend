package com.snqg.task.service;

import com.snqg.task.domain.vo.TaskFinishedVo;
import com.snqg.task.domain.vo.TaskVo;
import com.snqg.task.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ldj123456789
* @description 针对表【task(任务表)】的数据库操作Service
* @createDate 2023-11-04 22:44:45
*/

public interface TaskService extends IService<Task> {

    boolean isTrueChildSendTask( String childId, int id, String detail, String taskurl);
    List<TaskVo> getTaskMessage(String childId);

    List<TaskFinishedVo> getAllFinishedTaskMessage(String childId);

    List<TaskFinishedVo> getTodayFinishedTaskMessage(String childId);

    List<TaskFinishedVo> getFinishedNotGetPointTask(String childId);
}

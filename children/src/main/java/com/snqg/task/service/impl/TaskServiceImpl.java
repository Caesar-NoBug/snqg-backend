package com.snqg.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.task.entity.Task;
import com.snqg.task.service.TaskService;
import com.snqg.task.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author ldj123456789
* @description 针对表【task(任务表)】的数据库操作Service实现
* @createDate 2023-11-04 22:44:45
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

    @Override
    public boolean isTrueChildSendTask(int childId, int id, String detail, String taskUrl) {
        return false;
    }
}





package com.snqg.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.task.domain.vo.TaskVo;
import com.snqg.task.entity.Task;
import com.snqg.task.service.TaskService;
import com.snqg.task.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author ldj123456789
* @description 针对表【task(任务表)】的数据库操作Service实现
* @createDate 2023-11-04 22:44:45
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

    @Autowired
    private TaskMapper taskMapper;
    @Override
    public boolean isTrueChildSendTask(int childId, int id, String detail, String taskUrl) {
        Task task = new Task();
        task.setChildId(String.valueOf(childId));
        task.setId(id);
        task.setDetail(detail);
        task.setTaskurl(taskUrl);

        taskMapper.insert(task);
        return true;
    }

    @Override
    public List<TaskVo> getTaskMessage(int childId) {

//        通过小孩id查询属于他的任务
        List<Task> tasks = new ArrayList<>();

        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("child_id",childId);
        tasks = taskMapper.selectList(queryWrapper);

//        判断是否有这个小孩
        if(tasks.isEmpty()) {
            return null;
        }

        List<TaskVo> taskVoList = new ArrayList<>();
        for( Task task : tasks ){
            TaskVo taskVo = new TaskVo();
            taskVo.setId(task.getId());
            taskVo.setType(task.getType());
            taskVo.setTaskUrl(task.getTaskurl());
            taskVo.setDetail(task.getDetail());
            taskVo.setTitle(task.getTitle());
            taskVo.setProgression(task.getProgression());

            taskVoList.add(taskVo);
        }
        return taskVoList;
    }


}





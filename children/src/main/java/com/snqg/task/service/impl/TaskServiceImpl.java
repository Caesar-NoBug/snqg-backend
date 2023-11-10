package com.snqg.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.children.entity.User;
import com.snqg.children.mapper.UserMapper;
import com.snqg.point.entity.Point;
import com.snqg.point.mapper.PointMapper;
import com.snqg.point.service.PointService;
import com.snqg.task.domain.vo.TaskFinishedVo;
import com.snqg.task.domain.vo.TaskVo;
import com.snqg.task.entity.Submission;
import com.snqg.task.entity.Task;
import com.snqg.task.service.TaskService;
import com.snqg.task.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Autowired
    private PointMapper pointMapper;

    @Autowired
    private  UserMapper userMapper;

    private final PointService pointService;

    @Autowired
    public TaskServiceImpl( PointService pointService ){
        this.pointService = pointService;
    }





    @Override
    public boolean isTrueChildSendTask(int childId, int id, String detail, String taskUrl) {
//        往数据库中存储任务信息
//        如果Progression == 100 ，则表示任务完成。
        Task task = new Task();
        task.setChildId(String.valueOf(childId));
        task.setId(id);
        task.setDetail(detail);
        task.setTaskurl(taskUrl);
        task.setProgression(100);

//        假设task数据中已有相关的数据，如果没有返回false
        taskMapper.updateById(task);

        List<Task> tasks = new ArrayList<>();
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("child_id",childId);
        tasks = taskMapper.selectList(queryWrapper);

        for(Task task1: tasks){
            if(childId == Integer.valueOf(task1.getChildId())){
                task = task1;
                break;
            }
        }

//        修改user的积分
        User user = new User();
        user = userMapper.selectUserById(String.valueOf(childId));
        int temp = task.getTaskPoint() + user.getPoint();
        user.setPoint(temp);

        userMapper.updateById(user);

//        插入一条积分修改信息
        Point point = new Point();
        point.setChangeTime(LocalDateTime.now());
        point.setId(childId);
        point.setTaskDesc(detail);
        point.setChangedPoint(task.getTaskPoint());
        pointMapper.insert(point);

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
//            已完成的任务不记录
            if( task.getProgression() != 100 ){
                TaskVo taskVo = new TaskVo();
                taskVo.setId(task.getId());
                taskVo.setType(task.getType());
                taskVo.setTaskUrl(task.getTaskurl());
                taskVo.setDetail(task.getDetail());
                taskVo.setTitle(task.getTitle());
                taskVo.setProgression(task.getProgression());
                taskVo.setTaskPoint(task.getTaskPoint());


                taskVoList.add(taskVo);
            }
        }
        return taskVoList;
    }

//    得到所有已完成的任务
    @Override
    public List<TaskFinishedVo> getAllFinishedTaskMessage(int childId) {

//        通过小孩id查询属于他的任务
        List<Task> tasks = new ArrayList<>();

        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("child_id",childId);
        queryWrapper.eq("progression",100);
        tasks = taskMapper.selectList(queryWrapper);

        if(tasks.isEmpty()) {
            return null;
        }

        List<TaskFinishedVo> taskFinishedVoList = new ArrayList<>();
        for( Task task : tasks ){
                TaskFinishedVo taskVo = new TaskFinishedVo();
                taskVo.setId(task.getId());
                taskVo.setType(task.getType());
                taskVo.setTaskUrl(task.getTaskurl());
                taskVo.setDetail(task.getDetail());
                taskVo.setTitle(task.getTitle());
                taskVo.setTaskFinishTime(task.getTaskFinishTime());

                taskFinishedVoList.add(taskVo);

        }
        return taskFinishedVoList;
    }

//    得到所有今天已完成的任务
    @Override
    public List<TaskFinishedVo> getTodayFinishedTaskMessage(int childId) {

//        通过小孩id查询属于他的任务
        List<Task> tasks = new ArrayList<>();

        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("child_id",childId);
        queryWrapper.eq("progression",100);
        tasks = taskMapper.selectList(queryWrapper);

        if(tasks.isEmpty()) {
            return null;
        }

        List<TaskFinishedVo> taskFinishedVoList = new ArrayList<>();
        for( Task task : tasks ){


            LocalDateTime startTime = LocalDate.now().atTime(0, 0, 0);
            LocalDateTime endTime = LocalDate.now().atTime(23, 59, 59);
//            仅记录今日任务
            if(task.getTaskFinishTime().isAfter(startTime) && task.getTaskFinishTime().isBefore(endTime)) {
                TaskFinishedVo taskVo = new TaskFinishedVo();
                taskVo.setId(task.getId());
                taskVo.setType(task.getType());
                taskVo.setTaskUrl(task.getTaskurl());
                taskVo.setDetail(task.getDetail());
                taskVo.setTitle(task.getTitle());
                taskVo.setTaskFinishTime(task.getTaskFinishTime());

                taskFinishedVoList.add(taskVo);
            }
        }
        return taskFinishedVoList;
    }


}





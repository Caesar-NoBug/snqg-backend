package com.snqg.task.controller;

import com.snqg.context.UserHolder;
import com.snqg.domain.response.Response;
import com.snqg.point.service.PointService;
import com.snqg.task.domain.dto.task.request.FindHelpRequest;
import com.snqg.task.domain.dto.task.request.GetTaskRequset;
import com.snqg.task.domain.dto.task.response.GetAllFinishedTaskResponse;
import com.snqg.task.domain.dto.task.response.GetTaskResponse;
import com.snqg.task.domain.dto.task.response.FindHelpFeedbackResponse;
import com.snqg.task.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//任务模块
@RestController
@Api(tags = "任务")
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private PointService pointService;

    @ApiOperation("完成任务后提交任务请求")
    @GetMapping("/sendTaskFinishRequest")
    public Response<FindHelpFeedbackResponse> sendTaskFinishRequest(
            @RequestBody FindHelpRequest findHelpRequest
    ) {
        String childId = UserHolder.getUserId();
        FindHelpFeedbackResponse findHelpFeedbackResponse = new FindHelpFeedbackResponse();
        findHelpFeedbackResponse.setYesOrNo(taskService.isTrueChildSendTask(Integer.valueOf(childId),findHelpRequest.getId(),
                findHelpRequest.getDetail(),findHelpRequest.getTaskUrl()));
        return Response.ok(findHelpFeedbackResponse);
    }

    @ApiOperation("获取当前小孩下，他的任务信息")
    @GetMapping("/getTask")
    public Response<GetTaskResponse> getTask(){

        String childId = UserHolder.getUserId();
        GetTaskResponse getTaskResponse = new GetTaskResponse();
        getTaskResponse.setTaskVoList(taskService.getTaskMessage(Integer.valueOf(childId)));

        return Response.ok(getTaskResponse);
    }
    @ApiOperation("获取当前小孩下，他完成的所有任务信息")
    @GetMapping("/getAllFinishedTask")
    public Response<GetAllFinishedTaskResponse> getAllFinishedTask(
    ){
        String childId = UserHolder.getUserId();
        GetAllFinishedTaskResponse getTaskResponse = new GetAllFinishedTaskResponse();
        getTaskResponse.setTaskFinishedVos(taskService.getAllFinishedTaskMessage(Integer.valueOf(childId)));

        return Response.ok(getTaskResponse);

    }


    @ApiOperation("获取今天，当前小孩下，他完成的任务信息")
    @GetMapping("/getTodayFinishedTask")
    public Response<GetAllFinishedTaskResponse> getTodayFinishedTask(
    ){
        String childId = UserHolder.getUserId();
        GetAllFinishedTaskResponse getTaskResponse = new GetAllFinishedTaskResponse();
        getTaskResponse.setTaskFinishedVos(taskService.getTodayFinishedTaskMessage(Integer.valueOf(childId)));

        return Response.ok(getTaskResponse);

    }
}

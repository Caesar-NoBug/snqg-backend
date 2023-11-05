package com.snqg.task.controller;

import com.snqg.domain.response.Response;
import com.snqg.task.domain.dto.task.request.FindHelpRequest;
import com.snqg.task.domain.dto.task.request.GetTaskRequset;
import com.snqg.task.domain.dto.task.response.GetTaskResponse;
import com.snqg.task.domain.dto.task.response.FindHelpFeedbackResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//任务模块
@RestController
@Api(tags = "任务")
@RequestMapping("/task")
public class TaskController {
    @ApiOperation("完成任务后提交任务请求")
    @GetMapping("/sendTaskFinishRequest")
    public Response<FindHelpFeedbackResponse> sendTaskFinishRequest(
            @RequestBody FindHelpRequest findHelpRequest
    ) {
//        String userId = UserHolder.getUserId();
//        // 在这里根据calculationType参数的值获取不同类型的积分总额
//        int totalPoints = 0;
//
//        if ("remaining".equals(calculationType)) {
//            totalPoints = userService.calculateRemainingPoints(userId);
//        } else if ("accumulated".equals(calculationType)) {
//            totalPoints = userService.calculateAccumulatedPoints(userId);
//        } else {
//            // 可以处理未知类型的情况，如抛出异常或返回默认值
//        }
//        return totalPoints;
        FindHelpFeedbackResponse findHelpFeedbackResponse = new FindHelpFeedbackResponse();
        return Response.ok(findHelpFeedbackResponse);
    }

    @ApiOperation("获取任务信息")
    @GetMapping("/getTask")
    public Response<GetTaskResponse> getTask(
            @RequestBody GetTaskRequset requset
            ){
        GetTaskResponse getTaskResponse = new GetTaskResponse();
        return Response.ok(getTaskResponse);
    }
}

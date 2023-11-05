package com.snqg.task.controller;

import com.snqg.domain.response.Response;
import com.snqg.task.domain.dto.submission.request.SendTaskFinishRequest;
import com.snqg.task.domain.dto.submission.response.GiveFeedbackResponse;
import com.snqg.task.service.SubmissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "求助")
@RequestMapping("/help")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @ApiOperation("提交求助请求")
    @GetMapping("/setHelpRequest")
    public Response<GiveFeedbackResponse> setHelpRequest(
            @RequestBody SendTaskFinishRequest calculationTypeRequest
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
        GiveFeedbackResponse giveFeedbackResponse = new GiveFeedbackResponse();
        return Response.ok(giveFeedbackResponse);
    }

}

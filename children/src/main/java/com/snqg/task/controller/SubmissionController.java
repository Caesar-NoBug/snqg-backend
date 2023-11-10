package com.snqg.task.controller;

import com.snqg.context.UserHolder;
import com.snqg.domain.response.Response;
import com.snqg.task.domain.dto.submission.request.SendTaskFinishRequest;
import com.snqg.task.domain.dto.submission.response.GiveFeedbackResponse;
import com.snqg.task.service.SubmissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Api(tags = "求助")
@RequestMapping("/help")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @ApiOperation("提交求助请求")
    @GetMapping("/setHelpRequest")
    public Response<GiveFeedbackResponse> setHelpRequest(
            @RequestBody SendTaskFinishRequest sendTaskFinishRequest
    ) {
        String childId = UserHolder.getUserId();
        GiveFeedbackResponse giveFeedbackResponse = new GiveFeedbackResponse();
        giveFeedbackResponse.setVolunteer(submissionService.seekHelpTask(
                Integer.valueOf(childId),sendTaskFinishRequest.getContent()));
        return Response.ok(giveFeedbackResponse);
    }

}

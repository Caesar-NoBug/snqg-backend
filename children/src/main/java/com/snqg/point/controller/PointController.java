package com.snqg.point.controller;

import com.snqg.domain.response.Response;
import com.snqg.point.domain.dto.point.request.CalculationTypeRequest;
import com.snqg.point.domain.dto.point.request.PointHistoryRequest;
import com.snqg.point.domain.dto.point.request.RankRequest;
import com.snqg.point.domain.dto.point.response.*;
import com.snqg.point.service.PointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//积分模块
@RestController
@Api(tags = "积分")
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointService pointService;
//    @Autowired
//    private SubmissionService submissionService;

    @ApiOperation("获取积分总额(累计值或剩余值)")
    @GetMapping("/getTotalPoints")
    public Response<TotalPointsResponse> getTotalPoints(
            @RequestBody CalculationTypeRequest calculationTypeRequest
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
        TotalPointsResponse totalPointsResponse = new TotalPointsResponse();
        return Response.ok(totalPointsResponse);
    }

    @ApiOperation("获取积分获取记录")
    @GetMapping("/getPointHistory")
    public Response<PointHistoryResponse> getPointHistory(
            @RequestBody PointHistoryRequest historyRequest
    ) {
//        String userId = UserHolder.getUserId();
//        // 在这里根据type参数的值获取不同类型的积分记录
//        List<PointRecord> pointRecords = new ArrayList<>();
//
//        if ("all".equals(type)) {
//            pointRecords = pointHistoryService.getPointHistoryForUser(userId);
//        } else if ("income".equals(type)) {
//            pointRecords = pointHistoryService.getIncomePointHistoryForUser(userId);
//        } else if ("expense".equals(type)) {
//            pointRecords = pointHistoryService.getExpensePointHistoryForUser(userId);
//        } else {
//            // 可以处理未知类型的情况，如抛出异常或返回默认值
//        }
//        return pointHistory;
        PointHistoryResponse pointHistoryResponse = new PointHistoryResponse();
        return Response.ok(pointHistoryResponse);
    }

    @ApiOperation("获取积分排名")
    @GetMapping("/getPointRank")
    public Response<PointRankResponse> getPointRank(
            @RequestBody RankRequest pointRankRequest
    ) {
        /*
        timeRange:
        1.total:总积分
        2.year:年度积分
        3.month:月度积分
        4.week:周积分
        rankingRange:
        1.system:系统范围内进行排名
        2.group:小组范围内进行排名
         */
//        String userId = UserHolder.getUserId();
//
//        pointsRanking = rankingService.getWeeklyGroupPointsRanking(userId, timeRange, rankingRange);
//        return pointsRanking;

        return Response.ok(new PointRankResponse());
    }

    @ApiOperation("获取完成任务个数(绘图)")
    @GetMapping("/getTaskCount")
    public Response<TaskStatusResponse> getTaskCount(@RequestBody RankRequest rankRequest) {
        TaskStatusResponse taskStatusResponse = new TaskStatusResponse();
        return Response.ok(taskStatusResponse);
    }

    @ApiOperation("获取积分个数(绘图)")
    @GetMapping("getPointCount")
    public Response<PointStatusResponse> getPointCount(@RequestBody RankRequest rankRequest) {
        PointStatusResponse pointStatusResponse = new PointStatusResponse();
        return Response.ok(pointStatusResponse);
    }

}
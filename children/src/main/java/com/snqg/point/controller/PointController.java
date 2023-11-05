package com.snqg.point.controller;

import com.snqg.context.UserHolder;
import com.snqg.domain.response.Response;
import com.snqg.point.domain.dto.point.request.CalculationTypeRequest;
import com.snqg.point.domain.dto.point.request.PointHistoryRequest;
import com.snqg.point.domain.dto.point.request.RankingRequest;
import com.snqg.point.domain.dto.point.response.*;
import com.snqg.point.domain.vo.PointStatusVO;
import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.domain.vo.TaskStatusVO;
import com.snqg.point.entity.Point;
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

    // ---------------------------------------------------------------------------------------------
    @ApiOperation("获取积分总额(累计值或剩余值)")
    @GetMapping("/getTotalPoints")
    public Response<TotalPointsResponse> getTotalPoints(
            @RequestBody CalculationTypeRequest calculationTypeRequest
    ) {
        String userId = UserHolder.getUserId();
        // 在这里根据calculationType参数的值获取不同类型的积分总额
        int totalPoints = -1;

        if ("remaining".equals(
                calculationTypeRequest.getCalculationType())) {
            totalPoints = pointService.getTotalPoints(userId, "remaining", "total");
        } else if ("accumulated".equals(
                calculationTypeRequest.getCalculationType())) {
            totalPoints = pointService.getTotalPoints(userId, "accumulated", "total");
        }

        TotalPointsResponse totalPointsResponse = new TotalPointsResponse();
        totalPointsResponse.setTotalPoints(totalPoints);
        return Response.ok(totalPointsResponse);
    }

    // ---------------------------------------------------------------------------------------------
    @ApiOperation("获取积分获取记录")
    @GetMapping("/getPointHistory")
    public Response<PointHistoryResponse> getPointHistory(
            @RequestBody PointHistoryRequest historyRequest
    ) {
        String userId = UserHolder.getUserId();
        // 在这里根据type参数的值获取不同类型的积分记录
        List<PointVO> pointRecords = new ArrayList<>();

        if ("all".equals(historyRequest.getType())) {
            pointRecords = pointService.getPointHistory(userId, "all");
        } else if ("income".equals(historyRequest.getType())) {
            pointRecords = pointService.getPointHistory(userId, "income");
        } else if ("expense".equals(historyRequest.getType())) {
            pointRecords = pointService.getPointHistory(userId, "expense");
        }

        PointHistoryResponse pointHistoryResponse = new PointHistoryResponse();
        pointHistoryResponse.setPointRecords(pointRecords);
        return Response.ok(pointHistoryResponse);
    }

    // ---------------------------------------------------------------------------------------------
    @ApiOperation("获取积分排名")
    @GetMapping("/getPointRank")
    public Response<PointRankResponse> getPointRank(
            @RequestBody RankingRequest pointRankingRequest
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
        String userId = UserHolder.getUserId();

        int pointsRanking = pointService.getPointRank(userId,
                pointRankingRequest.getTimeRange(), pointRankingRequest.getRankingRange());

        PointRankResponse pointRankResponse = new PointRankResponse();
        pointRankResponse.setPointRank(pointsRanking);
        return Response.ok(new PointRankResponse());
    }


    // ---------------------------------------------------------------------------------------------
    @ApiOperation("获取完成任务个数(绘图)")
    @GetMapping("/drawTaskCount")
    public Response<TaskStatusResponse> getTaskCount(@RequestBody RankingRequest rankingRequest) {

        String userId = UserHolder.getUserId();
        List<TaskStatusVO> taskStatusVOList = pointService.
                getDrawTaskData(userId, rankingRequest.getTimeRange());

        TaskStatusResponse taskStatusResponse = new TaskStatusResponse();
        taskStatusResponse.setTaskStatusVOList(taskStatusVOList);
        return Response.ok(taskStatusResponse);
    }

    @ApiOperation("获取积分个数(绘图)")
    @GetMapping("/drawPointCount")
    public Response<PointStatusResponse> getPointCount(@RequestBody RankingRequest rankingRequest) {

        String userId = UserHolder.getUserId();
        List<PointStatusVO> pointStatusVOList = pointService.
                getDrawPointData(userId, rankingRequest.getTimeRange());

        PointStatusResponse pointStatusResponse = new PointStatusResponse();
        pointStatusResponse.setPointStatusVOList(pointStatusVOList);
        return Response.ok(pointStatusResponse);
    }

}
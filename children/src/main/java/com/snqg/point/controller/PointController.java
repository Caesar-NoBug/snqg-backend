package com.snqg.point.controller;

import com.snqg.point.domain.dto.TaskStatusResponse;
import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.service.PointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public int getTotalPoints(@RequestParam(value = "calculationType") String calculationType) {
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

        return 0;
    }

    @ApiOperation("获取积分获取记录")
    @GetMapping("/getPointHistory")
    public List<PointVO> getPointHistory(@RequestParam(value = "type") String type) {
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

        return null;
    }

    @ApiOperation("获取积分排名")
    @GetMapping("/getPointRank")
    public int getPointRank(
            @RequestParam(value = "timeRange") String timeRange,
            @RequestParam(value = "rankingRange") String rankingRange
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

        return 0;
    }

    @ApiOperation("获取完成任务个数(绘图)")
    @GetMapping("/getTaskCount")
    public ResponseEntity<List<TaskStatusResponse>> getTaskCount(@RequestParam(value = "timeRange") String timeRange) {
        return null;
    }

    @ApiOperation("获取积分个数(绘图)")
    @GetMapping("getPointCount")
    public ResponseEntity<List<TaskStatusResponse>> getPointCount(@RequestParam(value = "timeRange") String timeRange) {
        return null;
    }

}
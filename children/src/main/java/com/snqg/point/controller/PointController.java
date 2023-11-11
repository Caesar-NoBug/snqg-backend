package com.snqg.point.controller;

import com.snqg.context.UserHolder;
import com.snqg.domain.response.Response;
import com.snqg.point.domain.dto.point.request.CalculationTypeRequest;
import com.snqg.point.domain.dto.point.request.PointHistoryRequest;
import com.snqg.point.domain.dto.point.request.RankingRequest;
import com.snqg.point.domain.dto.point.response.*;
import com.snqg.point.domain.vo.PointStatusVO;
import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.domain.vo.RankPercentageVO;
import com.snqg.point.domain.vo.TaskStatusVO;
import com.snqg.point.entity.Point;
import com.snqg.point.service.PointService;
import io.swagger.annotations.*;
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
    @ApiImplicitParam(name = "calculationType", value = "请求：积分商城界面之中显示积分的剩余值和积分排名界面之中显示积分的累计值；" +
            "参数功能：选择要显示剩余积分还是累计积分；" +
            "计算积分剩余值，可以用于显示剩余积分或者累计积分；" +
            "要显示剩余积分，传入\"remaining\"；" +
            "要显示累计积分，传入\"accumulated\"；", example = "accumulated")
    public Response<TotalPointsResponse> getTotalPoints(
            @RequestParam String calculationType
    ) {
        String userId = UserHolder.getUserId();
        // 在这里根据calculationType参数的值获取不同类型的积分总额
        int totalPoints = -1;

        if ("remaining".equals(calculationType)) {
            totalPoints = pointService.getTotalPoints(userId, "remaining", "total");
        } else if ("accumulated".equals(calculationType)) {
            totalPoints = pointService.getTotalPoints(userId, "accumulated", "total");
        }

        if (totalPoints == -1) {
            return Response.error("传入参数错误，获取积分总额失败");
        }
        TotalPointsResponse totalPointsResponse = new TotalPointsResponse();
        totalPointsResponse.setTotalPoints(totalPoints);
        return Response.ok(totalPointsResponse);
    }

    // ---------------------------------------------------------------------------------------------
    @ApiOperation("获取积分记录")
    @GetMapping("/getPointHistory")
    @ApiImplicitParam(name = "type", value = "请求：在积分商城界面之中显示积分收支记录（和不背单词之中的界面很像）；" +
            "参数功能：限定范围，获取积分记录时，可以选择显示:" +
            "1)\"all\", 显示全部积分记录" +
            "2)\"expense\", 仅显示积分支出记录" +
            "3)\"income\", 仅显示积分收入记录", example = "all")
    public Response<PointHistoryResponse> getPointHistory(
            @RequestParam String type
    ) {
        String userId = UserHolder.getUserId();
        // 在这里根据type参数的值获取不同类型的积分记录
        List<PointVO> pointRecords = new ArrayList<>();

        if ("all".equals(type)) {
            pointRecords = pointService.getPointHistory(userId, "all");
        } else if ("income".equals(type)) {
            pointRecords = pointService.getPointHistory(userId, "income");
        } else if ("expense".equals(type)) {
            pointRecords = pointService.getPointHistory(userId, "expense");
        }

        if (pointRecords == null) {
            return Response.error("传入参数错误，获取积分记录失败");
        }

        PointHistoryResponse pointHistoryResponse = new PointHistoryResponse();
        pointHistoryResponse.setPointRecords(pointRecords);
        return Response.ok(pointHistoryResponse);
    }

    // ---------------------------------------------------------------------------------------------
    @ApiOperation("获取积分排名")
    @GetMapping("/getPointRank")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "timeRange", value = "请求：在积分排名界面之中显示积分排名的数值；" +
                    "参数功能：设定排名的时间范围:" +
                    "1)传入\"total\", 限定时间范围为全部（对应总积分）" +
                    "2)传入\"year\", 限定时间范围为年（对应年度积分）" +
                    "3)传入\"month\", 限定时间范围为月（对应月度积分）" +
                    "4)传入\"week\", 限定时间范围为周（对应近七日在组内排名，传入这个参数时rankingRange请设置为\"group\"）",
                    example = "total"),
            @ApiImplicitParam(name = "rankingRange", value = "请求：在积分排名界面之中显示积分排名的数值；" +
                    "参数功能：设定排名的组别范围:" +
                    "1)传入\"system\", 表示在系统范围内进行排名（会在整个数据库之中进行检索排名）" +
                    "2)传入\"group\",  表示在组内进行排名（会在具有相同地理位置的孩子中间进行排名）",
                    example = "system")

    })
    public Response<PointRankResponse> getPointRank(
            @RequestParam String timeRange,
            @RequestParam String rankingRange
    ) {

        String userId = UserHolder.getUserId();

        int pointsRanking = pointService.getPointRank(userId,
                timeRange, rankingRange);

        if (pointsRanking == 0) {
            return Response.error("传入参数错误，获取积分排名失败");
        }

        PointRankResponse pointRankResponse = new PointRankResponse();
        pointRankResponse.setPointRank(pointsRanking);
        return Response.ok(pointRankResponse);
    }


    // ---------------------------------------------------------------------------------------------
    @ApiOperation("获取完成任务个数(绘图)")
    @GetMapping("/drawTaskCount")
    @ApiImplicitParam(name = "timeRange", value = "请求：在积分排名界面之中绘制每月/日完成任务个数的图像；" +
            "参数功能：设定曲线每一个点所跨越的时间范围:" +
            "3)传入\"month\", 限定时间范围为月（返回个人月度完成任务总数和系统平均完成任务总数）；" +
            "4)传入\"day\", 限定时间范围为天（返回个人天度～～）；",
            example = "month")
    public Response<TaskStatusResponse> getTaskCountToDraw(@RequestParam String timeRange) {

        String userId = UserHolder.getUserId();
        List<TaskStatusVO> taskStatusVOList = pointService.
                getDrawTaskData(userId, timeRange);

        if (taskStatusVOList == null) {
            return Response.error("传入参数错误，获取绘图数据失败（完成任务个数）");
        }
        TaskStatusResponse taskStatusResponse = new TaskStatusResponse();
        taskStatusResponse.setTaskStatusVOList(taskStatusVOList);
        return Response.ok(taskStatusResponse);
    }

    @ApiOperation("获取积分个数(绘图)")
    @GetMapping("/drawPointCount")
    @ApiImplicitParam(name = "timeRange", value = "请求：在积分排名界面之中绘制每月/日积分个数的图像；" +
            "参数功能：设定曲线每一个点所跨越的时间范围:" +
            "3)传入\"month\", 限定时间范围为月（返回个人月度积分总数和系统平均积分总数）；" +
            "4)传入\"day\", 限定时间范围为天（返回个人天度～～）；",
            example = "month")
    public Response<PointStatusResponse> getPointCountToDraw(@RequestParam String timeRange) {

        String userId = UserHolder.getUserId();
        List<PointStatusVO> pointStatusVOList = pointService.
                getDrawPointData(userId, timeRange);

        if (pointStatusVOList == null) {
            return Response.error("传入参数错误，获取绘图数据失败（积分个数）");
        }
        PointStatusResponse pointStatusResponse = new PointStatusResponse();
        pointStatusResponse.setPointStatusVOList(pointStatusVOList);
        return Response.ok(pointStatusResponse);
    }

    @ApiOperation("获取积分超越人数百分比(过去x个月)")
    @GetMapping("/getPointRankPercentage")
    @ApiImplicitParam(name="x", value = "请求：在积分排名界面之中显示积分超越人数百分比；" +
            "参数功能：设定超越人数百分比的时间范围：" +
            "传入\"x\", 限定时间范围为过去x个月；" , example = "4")
    public Response<PointRankPercentageResponse> getPointRankPercentage(int x) {

        String userId = UserHolder.getUserId();
        List<RankPercentageVO> rankPercentageVOList = pointService.getRankPercentage(userId, x);

        if (rankPercentageVOList == null) {
            return Response.error("传入参数错误，获取积分超越人数百分比失败");
        }

        PointRankPercentageResponse pointRankPercentageResponse = new PointRankPercentageResponse();
        pointRankPercentageResponse.setRankPercentageList(rankPercentageVOList);
        return Response.ok(pointRankPercentageResponse);
    }


    @ApiOperation("获取今日完成任务个数（GET方法进行请求）")
    @GetMapping("/getTodayTaskCount")
    public Response<TodayTaskCountResponse> getTodayTaskCount() {

        String userId = UserHolder.getUserId();
        int todayTaskCount = pointService.getTodayTaskCount(userId);

        if (todayTaskCount == -1) {
            return Response.error("传入参数错误，获取今日完成任务个数失败");
        }

        TodayTaskCountResponse todayTaskCountResponse = new TodayTaskCountResponse();
        todayTaskCountResponse.setTodayTaskCount(todayTaskCount);
        return Response.ok(todayTaskCountResponse);
    }

    @ApiOperation("获取累计完成任务个数（GET方法进行请求）")
    @GetMapping("/getTotalTaskCount")
    public Response<TotalTaskCountResponse> getTotalTaskCount() {

        String userId = UserHolder.getUserId();
        int totalTaskCount = pointService.getTaskCount(userId);

        if (totalTaskCount == -1) {
            return Response.error("传入参数错误，获取累计完成任务个数失败");
        }

        TotalTaskCountResponse totalTaskCountResponse = new TotalTaskCountResponse();
        totalTaskCountResponse.setTotalTaskCount(totalTaskCount);
        return Response.ok(totalTaskCountResponse);
    }

    @ApiOperation("获取今日获取积分个数（GET方法进行请求）")
    @GetMapping("/getTodayPointCount")
    public Response<TodayPointCountResponse> getTodayPointCount() {

        String userId = UserHolder.getUserId();
        int todayPointCount = pointService.getTodayPointCount(userId);

        if (todayPointCount == -1) {
            return Response.error("传入参数错误，获取今日获取积分个数失败");
        }

        TodayPointCountResponse todayPointCountResponse = new TodayPointCountResponse();
        todayPointCountResponse.setTodayPointCount(todayPointCount);
        return Response.ok(todayPointCountResponse);
    }


}
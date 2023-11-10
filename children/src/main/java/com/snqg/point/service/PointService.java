package com.snqg.point.service;

import com.snqg.point.domain.dto.point.PointUserDTO;
import com.snqg.point.domain.vo.PointStatusVO;
import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.domain.vo.RankPercentageVO;
import com.snqg.point.domain.vo.TaskStatusVO;
import com.snqg.point.entity.Point;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author zilu
* @description 针对表【point(积分变化表)】的数据库操作Service
* @createDate 2023-11-03 12:02:40
*/
public interface PointService extends IService<Point> {

    /**
     * 获取积分获取记录
     * @param userId
     * @param type
     * @return
     */
    List<PointVO> getPointHistory(String userId, String type);

    /**
     * 获取积分总额(累计值或剩余值)
     * @param userId
     * @param type
     * @param timeRange
     * @return
     */
    int getTotalPoints(String userId, String type, String timeRange);

    /**
     * 获取用于绘图的积分状态
     * @param userId
     * @param timeRange
     * @return
     */
    List<PointStatusVO> getDrawPointData(String userId, String timeRange);

    /**
     * 获取积分排名(数值越大排名越靠前)
     * @param userId
     * @param timeRange
     * @param rankingRange
     * @return
     */
    int getPointRank(String userId, String timeRange, String rankingRange);

    /**
     * 获取任务完成个数
     * @param userId
     * @return
     */
    int getTaskCount(String userId);

    /**
     * 获取用于绘图的任务完成数量状态
     * @param userId
     * @param timeRange
     * @return
     */
    List<TaskStatusVO> getDrawTaskData(String userId, String timeRange);

    /**
     * 获取积分排名百分比
     * @param userId
     * @param x
     * @return
     */
    List<RankPercentageVO> getRankPercentage(String userId, int x);

    int getTodayTaskCount(String userId);

    int getAccumulatedTaskCount(String userId);

    int getTodayPointCount(String userId);
}

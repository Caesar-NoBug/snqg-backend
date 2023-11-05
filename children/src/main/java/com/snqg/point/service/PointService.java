package com.snqg.point.service;

import com.snqg.point.domain.vo.PointVO;
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
}

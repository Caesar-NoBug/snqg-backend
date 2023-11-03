package com.snqg.point.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.point.domain.MsPointStruct;
import com.snqg.point.domain.dto.PointStatus;
import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.entity.Point;
import com.snqg.point.service.PointService;
import com.snqg.point.mapper.PointMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author zilu
* @description 针对表【point(积分变化表)】的数据库操作Service实现
* @createDate 2023-11-03 12:02:40
*/
@Service
public class PointServiceImpl extends ServiceImpl<PointMapper, Point>
    implements PointService{

    @Resource
    private MsPointStruct msPointStruct;


    @Override
    public int getTotalPoints(String userId, String type) {
        return 0;
    }

    @Override
    public List<PointVO> getPointHistory(String userId, String type) {
        return null;
    }

    @Override
    public int getTotalPoint(String userId, String timeRange, String groupRange) {
        return 0;
    }

    public List<Integer> getPointList(String timeRange, String groupRange) {
        return null;
    }

    public int getPointRank(String userId, String timeRange, String groupRange) {
        return 0;
    }

    public List<PointStatus> getPointCount(String userId, String timeRange, String groupRange) {
        return null;
    }

}





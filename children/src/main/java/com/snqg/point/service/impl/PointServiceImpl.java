package com.snqg.point.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.children.mapper.UserMapper;
import com.snqg.point.domain.MsPointStruct;
import com.snqg.point.domain.vo.PointStatusVO;
import com.snqg.point.domain.dto.point.PointUserDTO;
import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.entity.Point;
import com.snqg.point.service.PointService;
import com.snqg.point.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private PointMapper pointMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取积分获取记录
     * @param userId
     * @param type
     * @return
     */
    @Override
    public List<PointVO> getPointHistory(String userId, String type) {

        List<Point> pointHistoryList = new ArrayList<>();

        QueryWrapper<Point> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        if ("income".equals(type)) {
            queryWrapper.gt("changed_point", 0);
        } else if ("expense".equals(type)) {
            queryWrapper.lt("changed_point", 0);
        } else {
            return null;
        }

        queryWrapper.orderByDesc("change_time"); // 按时间从新到旧排序

        pointHistoryList = pointMapper.selectList(queryWrapper);

        List<PointVO> pointVOList = new ArrayList<>();
        for (Point pointHistory : pointHistoryList) {
            // 根据 pointHistory 数据映射到 PointVO 对象
            PointVO pointVO = msPointStruct.pointToVO(pointHistory);
            pointVOList.add(pointVO);
        }

        return pointVOList;
    }

    /**
     * 获取积分总额(累计值或剩余值)
     * @param userId
     * @param type
     * @param timeRange
     * @return
     */
    @Override
    public int getTotalPoints(String userId, String type, String timeRange) {
         /*
        timeRange:
        1.total:总积分
        2.year:年度积分
        3.month:月度积分
        4.week:周积分
         */
        QueryWrapper<Point> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        if ("total".equals(timeRange)) {
            // 总积分，不需要额外的时间范围条件
        } else if ("year".equals(timeRange)) {
            queryWrapper.ge("change_time",
                    LocalDate.now().minusYears(1)); // 查询过去一年的记录
        } else if ("month".equals(timeRange)) {
            queryWrapper.ge("change_time",
                    LocalDate.now().minusMonths(1)); // 查询过去一个月的记录
        } else if ("week".equals(timeRange)) {
            queryWrapper.ge("change_time",
                    LocalDate.now().minusWeeks(1)); // 查询过去一周的记录
        } else {
            // 未知的时间范围
            return -1;
        }

        if ("remaining".equals(type)) {
            // 不需要额外的条件
        } else if ("accumulated".equals(type)) {
            queryWrapper.gt("changed_point", 0);
        } else {
            // 未知的积分类型
            return -1;
        }

        List<Point> pointsList = pointMapper.selectList(queryWrapper);
        int totalPoints = 0;
        for (Point points : pointsList) {
            totalPoints += points.getChangedPoint();
        }

        return totalPoints;
    }

    /**
     * 获取积分列表（包含所有儿童）
     * @param timeRange
     * @param rankingRange
     * @return
     */
    private List<PointUserDTO> getPointUserDTOList(String timeRange, String rankingRange) {

        Map<String, String> params = new HashMap<>();
        if (timeRange.equals("year")) {
            // 查询过去一年的记录
            params.put("timeRangeSQL", String.format("p.change_time >= %s AND p.change_time <= %s",
                    LocalDate.now().minusYears(1), LocalDate.now()));
        } else if (timeRange.equals("month")) {
            // 查询过去一个月的记录
            params.put("timeRangeSQL", String.format("p.change_time >= %s AND p.change_time <= %s",
                    LocalDate.now().minusMonths(1), LocalDate.now()));
        } else if (timeRange.equals("week")) {
            // 查询过去一周的记录
            params.put("timeRangeSQL", String.format("p.change_time >= %s AND p.change_time <= %s",
                    LocalDate.now().minusWeeks(1), LocalDate.now()));
        } else if (timeRange.equals("total")) {
            // 总积分，不需要额外的时间范围条件
            params.put("timeRangeSQL", "1=1");
        } else {
            return null;
        }

        if (rankingRange.equals("system")) {
            params.put("rankingRangeSQL", "1=1");
        } else {
            params.put("rankingRangeSQL", String.format("u.address = %s", rankingRange));
        }


        // 执行查询
        return pointMapper.selectPointUserRecords(
                params.get("timeRangeSQL"),
                params.get("rankingRangeSQL"));
    }

    /**
     * 获取积分排名
     * @param userId
     * @param timeRange
     * @param rankingRange
     * @return
     */
    public int getPointRank(String userId, String timeRange, String rankingRange) {

        List<PointUserDTO> pointUserDTOList = getPointUserDTOList(timeRange, rankingRange);
        if (pointUserDTOList != null) {
            Map<String, Integer> totalPointsByUserId = pointUserDTOList.stream()
                    .collect(Collectors.groupingBy(PointUserDTO::getUserId,
                            Collectors.summingInt(PointUserDTO::getChangedPoint)));

            List<String> sortedKeys = totalPointsByUserId.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());


            return sortedKeys.indexOf(userId) + 1;
        } else {
            return 0;
        }
    }

    /**
     * 获取每一天或每一月的积分变化情况
     * 包含userId对应的儿童的积分以及整个系统积分的平均值
     * @param userId
     * @param timeRange
     * @return
     */
    public List<PointStatusVO> getDrawPointData(String userId, String timeRange) {

        List<PointUserDTO> pointUserDTOList;
        if (timeRange.equals("mouth")) {
            pointUserDTOList = getPointUserDTOList("year", "system");
        } else if (timeRange.equals("week")) {
            pointUserDTOList = getPointUserDTOList("week", "system");
        } else {
            return null;
        }

        if (pointUserDTOList != null) {
//            Map<String, List<PointUserDTO>> groupedByTimeRange = pointUserDTOList.stream()
//                    .collect(Collectors.groupingBy(dto -> determineTimeRange(dto)));
//            Map<String, Integer> totalPointsByUserId = pointUserDTOList.stream()
//                    .collect(Collectors.groupingBy(PointUserDTO::getUserId,
//                            Collectors.summingInt(PointUserDTO::getChangedPoint)));


        } else {
            return null;
        }

        return null;
    }

    /**
     * 用于根据PointUserDTO中的时间属性来确定时间范围。
     * @param dto
     * @param timeRange
     * @return
     */
    private static String determineTimeRange(PointUserDTO dto, String timeRange) {
        // 在这里实现根据DTO中的时间属性确定时间范围的逻辑
        // 返回时间范围的标识，比如字符串
        return "TimeRangeA";
    }

}





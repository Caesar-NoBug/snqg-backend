package com.snqg.point.mapper;

import com.snqg.point.domain.dto.point.PointUserDTO;
import com.snqg.point.entity.Point;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;


/**
* @author zilu
* @description 针对表【point(积分变化表)】的数据库操作Mapper
* @createDate 2023-11-03 12:02:40
* @Entity com.snqg.point.entity.Point
*/
public interface PointMapper extends BaseMapper<Point> {
    List<PointUserDTO> selectPointUserRecords(@Param("timeRangeSQL") String timeRangeSQL,
                                              @Param("rankingRangeSQL") String rankingRangeSQL);
}





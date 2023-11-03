package com.snqg.point.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.point.entity.Point;
import com.snqg.point.service.PointService;
import com.snqg.point.mapper.PointMapper;
import org.springframework.stereotype.Service;

/**
* @author zilu
* @description 针对表【point(积分变化表)】的数据库操作Service实现
* @createDate 2023-11-03 12:02:40
*/
@Service
public class PointServiceImpl extends ServiceImpl<PointMapper, Point>
    implements PointService{

}





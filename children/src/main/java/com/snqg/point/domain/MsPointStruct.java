package com.snqg.point.domain;

import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.entity.Point;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MsPointStruct {
    //这里需要对象的对应属性名称相同
    PointVO pointToVO(Point point);
}

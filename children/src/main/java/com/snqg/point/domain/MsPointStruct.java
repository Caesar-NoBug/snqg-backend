package com.snqg.point.domain;

import com.snqg.point.domain.vo.PointVO;
import com.snqg.point.entity.Point;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MsPointStruct {

    @Mappings({
            @Mapping(source = "changedPoint", target = "changedPoint"),
            @Mapping(source = "changeTime", target = "changeTime"),
            @Mapping(source = "taskDesc", target = "taskDesc")
    })
    PointVO toPointVO(Point point);
}

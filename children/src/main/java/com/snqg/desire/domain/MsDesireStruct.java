package com.snqg.desire.domain;

import com.snqg.desire.domain.vo.DesireVo;
import com.snqg.desire.entity.Desire;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MsDesireStruct {

    DesireVo desireToVo(Desire desire);

}

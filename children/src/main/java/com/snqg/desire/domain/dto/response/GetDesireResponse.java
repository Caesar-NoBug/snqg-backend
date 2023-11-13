package com.snqg.desire.domain.dto.response;

import com.snqg.desire.domain.vo.DesireVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

//返回一个child的所有的愿望的详细信息（不包括感谢）
@Data
public class GetDesireResponse {

    @ApiModelProperty(value = "愿望详细信息列表",example = "")
    private List<DesireVo> desireVoList;

}

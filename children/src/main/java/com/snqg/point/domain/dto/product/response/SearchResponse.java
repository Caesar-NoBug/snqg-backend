package com.snqg.point.domain.dto.product.response;

import com.snqg.point.domain.vo.ProductVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    @ApiModelProperty(value = "搜索结果列表", example = "")
    private List<ProductVO> productVOList;
}

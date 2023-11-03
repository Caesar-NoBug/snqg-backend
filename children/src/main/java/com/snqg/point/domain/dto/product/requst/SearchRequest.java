package com.snqg.point.domain.dto.product.requst;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class SearchRequest {
    @ApiModelProperty(value = "discounted", example = "1")
    private int isDiscounted;
    @ApiModelProperty(value = "productName", example = "老人与海")
    private String productName;
    @ApiModelProperty(value = "category", example = "2")
    private int category;
}

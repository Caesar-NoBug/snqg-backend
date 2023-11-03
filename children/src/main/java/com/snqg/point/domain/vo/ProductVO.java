package com.snqg.point.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    @ApiModelProperty(value = "商品名称", example = "老人与海")
    private String name;
    @ApiModelProperty(value = "商品描述", example = "这是一本很有趣的书")
    private String desc;
    @ApiModelProperty(value = "商品价格", example = "898")
    private Integer price;
    @ApiModelProperty(value = "商品剩余个数", example = "3")
    private Integer count;
}

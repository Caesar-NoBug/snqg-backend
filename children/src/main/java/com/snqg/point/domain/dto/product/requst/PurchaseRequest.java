package com.snqg.point.domain.dto.product.requst;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class PurchaseRequest {
    @ApiModelProperty(value = "请求：在积分商城之中进行商品的购买；" +
            "参数类型：整形" +
            "参数功能：向后端传入要购买的商品的Id", example = "1")
    private int productId;
}

package com.snqg.point.domain.dto.product.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PurchaseResponse {

    @ApiModelProperty(value = "message", example = "购买成功")
    private String purchaseResult;
}

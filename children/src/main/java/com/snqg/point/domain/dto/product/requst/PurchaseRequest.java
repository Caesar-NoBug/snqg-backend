package com.snqg.point.domain.dto.product.requst;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class PurchaseRequest {
    @ApiModelProperty(value = "productId", example = "uia72")
    private String productId;
}

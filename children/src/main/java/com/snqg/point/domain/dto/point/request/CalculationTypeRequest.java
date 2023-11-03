package com.snqg.point.domain.dto.point.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CalculationTypeRequest {
    @ApiModelProperty(value = "calculationType", example = "remaining/accumulated")
    private String calculationType;
}

package com.snqg.desire.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RemoveThanksResponse {

    @ApiModelProperty(value = "message",example = "成功")
    private String message;
}

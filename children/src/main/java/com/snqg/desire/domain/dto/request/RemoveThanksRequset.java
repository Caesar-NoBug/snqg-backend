package com.snqg.desire.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RemoveThanksRequset {

    @ApiModelProperty(value = "愿望id",example = "1145")
    private int id;
}

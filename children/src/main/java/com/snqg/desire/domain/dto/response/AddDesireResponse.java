package com.snqg.desire.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//返回添加愿望成功与否
@Data
public class AddDesireResponse {

    //domain有Response，故此处不必有message
    //@ApiModelProperty()
    //private String message;
}

package com.snqg.domain.response.chat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SendMessageResponse {

    @ApiModelProperty(value = "是否发送成功", example = "true")
    private Boolean isSuccess;

}

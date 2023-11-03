package com.snqg.domain.request.chat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SendMessageRequest {

    @ApiModelProperty(value = "接收者id", example = "o2HEN5a1-62AL1SDc18g4lW7PQUg")
    private String receiverId;

    @ApiModelProperty(value = "消息内容", example = "hello, world")
    private String content;
}

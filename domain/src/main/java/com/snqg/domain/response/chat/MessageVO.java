package com.snqg.domain.response.chat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
public class MessageVO {

    @ApiModelProperty(value = "发送人id", example = "o2HEN5a1-62AL1SDc18g4lW7PQUg")
    private String senderId;

    @ApiModelProperty(value = "发送人用户名", example = "志愿者007")
    private String sender;

    @ApiModelProperty(value = "接收人id", example = "8UHEN5a1-02BL7SDc08g4lW7qQUP")
    private String receiverId;

    @ApiModelProperty(value = "接收人用户名", example = "儿童01")
    private String receiver;

    @ApiModelProperty(value = "消息内容", example = "你好，我是志愿者007")
    private String content;

    @ApiModelProperty(value = "发送时间", example = "1970-01-01T19:26:02.928")
    private LocalDateTime sendTime;

}

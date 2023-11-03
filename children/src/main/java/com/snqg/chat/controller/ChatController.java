package com.snqg.chat.controller;

import com.snqg.domain.request.chat.SendMessageRequest;
import com.snqg.domain.response.Response;
import com.snqg.domain.response.chat.MessageVO;
import com.snqg.domain.response.chat.SendMessageResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

//聊天模块
@RestController
@Api(tags = "聊天")
@RequestMapping("/chat")
public class ChatController {

    @ApiOperation("获取消息记录(begin time以后接收到的消息)")
    @GetMapping("/pull/{beginTime}")
    public Response<MessageVO> pullMessage(@ApiParam(name = "开始时间", example = "2023-11-03T12:04:08")
                                      @PathVariable LocalDateTime beginTime) {
        return null;
    }

    @ApiOperation("发送消息")
    @PostMapping("/send")
    public Response<SendMessageResponse> sendMessage(@RequestBody SendMessageRequest request) {
        return null;
    }

}

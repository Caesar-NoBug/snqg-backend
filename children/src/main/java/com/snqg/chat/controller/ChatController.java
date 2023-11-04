package com.snqg.chat.controller;

import com.alibaba.fastjson.JSON;
import com.snqg.chat.service.MessageService;
import com.snqg.context.UserHolder;
import com.snqg.domain.request.chat.SendMessageRequest;
import com.snqg.domain.response.Response;
import com.snqg.domain.response.chat.FriendVO;
import com.snqg.domain.response.chat.MessageVO;
import com.snqg.domain.response.chat.SendMessageResponse;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//聊天模块
@RestController
@Api(tags = "聊天")
@RequestMapping("/chat")
@Validated
public class ChatController {

    @Resource
    private MessageService messageService;

    @ApiOperation("获取消息记录(begin time以后接收到的消息)")
    @GetMapping("/pull/{startTime}")
    public Response<List<MessageVO>> pullMessage(@ApiParam(name = "startTime", example = "1699096038369")
                                      @PathVariable Long startTime) {
        String userId = UserHolder.getUserId();
        return Response.ok(messageService.pullMessage(userId, new Date(startTime)));

    }

    @ApiOperation("发送消息")
    @PostMapping("/send")
    public Response<SendMessageResponse> sendMessage(@RequestBody SendMessageRequest request) {
        String userId = UserHolder.getUserId();
        return Response.ok(messageService.sendMessage(userId, request));
    }

    @ApiOperation("获取好友列表")
    @GetMapping("/friend/list")
    public Response<List<FriendVO>> getFriendList() {
        return Response.ok(messageService.getFriendList(UserHolder.getUserId()));
    }

    public static void main(String[] args) {
        MessageVO vo = new MessageVO();
        vo.setSendTime(new Date());
        System.out.println(JSON.toJSONString(vo));
    }
}

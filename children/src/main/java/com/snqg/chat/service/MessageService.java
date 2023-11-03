package com.snqg.chat.service;

import com.snqg.chat.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snqg.domain.request.chat.SendMessageRequest;
import com.snqg.domain.response.chat.MessageVO;
import com.snqg.domain.response.chat.SendMessageResponse;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author caesar
* @description 针对表【message(消息表)】的数据库操作Service
* @createDate 2023-11-03 14:08:40
*/
public interface MessageService extends IService<Message> {

    List<MessageVO> pullMessage(String userId, LocalDateTime startTime);

    SendMessageResponse sendMessage(String userId, SendMessageRequest request);

}

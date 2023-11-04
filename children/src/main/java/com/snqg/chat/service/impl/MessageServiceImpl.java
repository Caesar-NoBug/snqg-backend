package com.snqg.chat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.chat.domain.MsMessageStruct;
import com.snqg.chat.entity.Message;
import com.snqg.chat.service.MessageService;
import com.snqg.chat.mapper.MessageMapper;
import com.snqg.common.exception.ThrowUtil;
import com.snqg.domain.request.chat.SendMessageRequest;
import com.snqg.domain.response.chat.MessageVO;
import com.snqg.domain.response.chat.SendMessageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author caesar
* @description 针对表【message(消息表)】的数据库操作Service实现
* @createDate 2023-11-03 14:08:40
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private MsMessageStruct messageStruct;

    @Override
    public List<MessageVO> pullMessage(String userId, LocalDateTime startTime) {
        return messageMapper.pullMessage(userId, startTime)
                .stream()
                .map(messageStruct::msDOToVO)
                .collect(Collectors.toList());
    }

    @Override
    public SendMessageResponse sendMessage(String userId, SendMessageRequest request) {

        ThrowUtil.throwIf(messageMapper.isFriend(userId, request.getReceiverId()) <= 0,
            "发送失败，该用户不是您的好友");

        Message message = new Message();
        message.setSenderId(userId);
        message.setReceiverId(request.getReceiverId());
        message.setContent(request.getContent());
        message.setSendTime(LocalDateTime.now());

        SendMessageResponse response = new SendMessageResponse();

        response.setIsSuccess(messageMapper.sendMessage(message) > 0);

        return response;
    }

}





package com.snqg.chat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snqg.chat.entity.Message;
import com.snqg.chat.service.MessageService;
import com.snqg.chat.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author caesar
* @description 针对表【message(消息表)】的数据库操作Service实现
* @createDate 2023-11-03 14:08:40
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




